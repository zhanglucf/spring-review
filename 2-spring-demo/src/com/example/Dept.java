package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dept {
    private String name;

    private Emp[] empArray;

    private String[] tagsArray;

    private List<Emp> empList;

    private Set<Emp> empSet;

    private Map<String,Object> empMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Dept setName");
        this.name = name;
    }

    public Emp[] getEmpArray() {
        return empArray;
    }

    public void setEmpArray(Emp[] empArray) {
        this.empArray = empArray;
    }

    public String[] getTagsArray() {
        return tagsArray;
    }

    public void setTagsArray(String[] tagsArray) {
        this.tagsArray = tagsArray;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public Set<Emp> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Emp> empSet) {
        this.empSet = empSet;
    }

    public Map<String, Object> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<String, Object> empMap) {
        this.empMap = empMap;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", empArray=" + Arrays.toString(empArray) +
                ", tagsArray=" + Arrays.toString(tagsArray) +
                ", empList=" + empList +
                ", empSet=" + empSet +
                ", empMap=" + empMap +
                '}';
    }
}
