package com.PaymentService.service.Impl;

import com.PaymentService.dto.*;
import com.PaymentService.entity.CompanyEntity;
import com.PaymentService.entity.RoleEntity;
import com.PaymentService.entity.UsersEntity;
import com.PaymentService.repository.CompanyRepository;
import com.PaymentService.repository.RoleRepository;
import com.PaymentService.repository.UsersRepository;
import com.PaymentService.service.UserService;
import com.PaymentService.utils.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper, CompanyRepository companyRepository, RoleRepository roleRepository) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Response createUsers(UsersDto usersDto) {
        CompanyEntity currentCompany = companyRepository.findByIdAndStatus(usersDto.getCompanyId(), 1);
        if (currentCompany == null) {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                    "Company not found by the requested companyId");
        }
        UsersEntity usersEntity = usersRepository.findByUserNameAndStatus(usersDto.getUserName(), 1);
        if (usersEntity == null) {
            usersEntity = modelMapper.map(usersDto, UsersEntity.class);
            usersEntity.setStatus(1);
            UsersEntity savedUsers = usersRepository.save(usersEntity);
            UsersDto convertUsers = modelMapper.map(savedUsers, UsersDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, convertUsers, "Successfully Created");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                "Username already exists");
    }

    @Override
    public Response getAllUsers() {
        List<UsersEntity> entities = usersRepository.findAllByStatus(1);
        if (!entities.isEmpty()) {
            List<UsersDto> usersDtos = new ArrayList<>();
            for (UsersEntity entity : entities) {
                usersDtos.add(modelMapper.map(entity, UsersDto.class));
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, usersDtos,
                    "Successfully Retrieved");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

    @Override
    public Response getUserById(Long id) {
        UsersEntity usersEntity = usersRepository.findByIdAndStatus(id, 1);
        if (usersEntity != null) {
            UsersDto convertUsers = modelMapper.map(usersEntity, UsersDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, convertUsers,
                    "Successfully Retrieved");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

    @Override
    public Response deleteUserById(Long id) {
        UsersEntity usersEntity = usersRepository.findByIdAndStatus(id, 1);
        if (usersEntity != null) {
            usersEntity.setStatus(0);
            UsersEntity savedUsers = usersRepository.save(usersEntity);
            UsersDto convertUsers = modelMapper.map(savedUsers, UsersDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, convertUsers,
                    "Successfully Deleted");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

    @Override
    public Response editUserById(Long id, UsersDto usersDto) {
        UsersEntity usersEntity = usersRepository.findByIdAndStatus(id, 1);
        if (usersEntity != null) {
            usersEntity = modelMapper.map(usersDto, UsersEntity.class);
            usersEntity.setStatus(1);
            UsersEntity savedUsers = usersRepository.save(usersEntity);
            UsersDto convertUsers = modelMapper.map(savedUsers, UsersDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, convertUsers,
                    "Successfully Updated");

        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

    @Override
    public Response assignRoleToUser(ConcatIdDto concatIdDto) {
        UsersEntity usersEntity = usersRepository.findByIdAndStatus(concatIdDto.getUserId(), 1);
        if (usersEntity == null) {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                    "UserId not found");
        }
        RoleEntity roleEntity = roleRepository.findByIdAndStatus(concatIdDto.getRoleId(), 1);
        if (roleEntity == null) {
            return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST, null,
                    "Role not found");
        }

        List<RoleEntity> allRoleList = usersEntity.getRoleEntityList();
        for (RoleEntity role : allRoleList) {
            if (Objects.equals(role.getId(), concatIdDto.getRoleId())) {
                return ResponseBuilder.getFailResponse(HttpStatus.BAD_REQUEST,
                        null,"Role already exists");
            }
        }
        allRoleList.add(roleEntity);

        usersEntity.setRoleEntityList(allRoleList);
        usersRepository.save(usersEntity);
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, null,
                "Successfully Assigned Role");
    }

    @Override
    public Response editMailAndPassword(EmailAndPasswordDto emailAndPasswordDto) {
        UsersEntity entities = usersRepository.findByIdAndStatus(emailAndPasswordDto.getUserId(), 1);
        if (entities != null) {
            entities.setStatus(1);
            entities.setEmail(emailAndPasswordDto.getEmail());
            entities.setPassword(emailAndPasswordDto.getPassword());
            UsersEntity savedUsers = usersRepository.save(entities);
            EmailAndPasswordDto convertemailAndPasswordDto = modelMapper.map(savedUsers, EmailAndPasswordDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, convertemailAndPasswordDto,
                    "Successfully Updated");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

    @Override
    public Response getVowelUsers() {
        List<UsersEntity> usersEntities = usersRepository.findAllByStatus(1);
        if (!usersEntities.isEmpty()) {
            List<UsersDto> usersDtos = new ArrayList<>();
            for (UsersEntity entity : usersEntities) {
                if (Objects.isNull(entity.getUserName())) {
                    continue;
                }
                char ch = entity.getUserName().toLowerCase().charAt(0);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    //entity.getRoleEntityList();
                    for (RoleEntity roleEntity : entity.getRoleEntityList()) {
                        char ch2 = roleEntity.getName().toLowerCase().charAt(0);
                        if (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') {
                            usersDtos.add(modelMapper.map(entity, UsersDto.class));
                            break;
                        }
                    }
                }
            }
            if (usersDtos.isEmpty()) {
                return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                        "No Users Found");
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, usersDtos,
                    "Successfully retrieved User and role");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

    @Override
    public Response getDistinctUsers(String fullName, String userName) {
        List<UsersEntity> usersEntities = usersRepository.findDistinctByFullNameAndUserName(fullName, userName);

        if (!usersEntities.isEmpty()) {
            List<UsersDto> usersDtos = new ArrayList<>();

            for (UsersEntity entity : usersEntities) {
                usersDtos.add(modelMapper.map(entity, UsersDto.class));
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, usersDtos,
                    "Successfully retrieved User");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

    @Override
    public Response getUsernameLike(String pattern) {
        List<UsersEntity> usersEntities=usersRepository.findByUserNameLikeAndStatus(pattern,1);
        if (!usersEntities.isEmpty()) {
            List<UsersDto> usersDtos=new ArrayList<>();
            for (UsersEntity entity : usersEntities) {
                usersDtos.add(modelMapper.map(entity, UsersDto.class));
            }
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, usersDtos,
                    "Successfully retrieved User");
        }
        return ResponseBuilder.getFailResponse(HttpStatus.NO_CONTENT, null,
                "No Users Found");
    }

}


