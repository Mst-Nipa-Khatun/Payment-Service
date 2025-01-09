package com.PaymentService.Nipa_2404134;

import java.util.ArrayList;
import java.util.List;

// Composite
class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void search(String keyword) {
        System.out.println("Searching in folder: " + name);
        for (FileSystemComponent component : children) {
            component.search(keyword);
        }
    }
}