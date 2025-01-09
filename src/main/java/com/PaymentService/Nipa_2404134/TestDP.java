package com.PaymentService.Nipa_2404134;

public class TestDP {
    public static void main(String[] args) {
        // Creating file system components
        File file1 = new File("File1", "This is the content of File1");
        File file2 = new File("File2", "This is the content of File2");
        File file3 = new File("File3", "This is the content of File3 containing keyword");

        Folder folder1 = new Folder("Folder1");
        folder1.add(file1);
        folder1.add(file2);

        Folder folder2 = new Folder("Folder2");
        folder2.add(file3);
        folder2.add(folder1);

        // Searching keyword in file system
        folder2.search("keyword");
    }
}
