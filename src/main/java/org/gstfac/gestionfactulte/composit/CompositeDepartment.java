package org.gstfac.gestionfactulte.composit;

import java.util.ArrayList;
import java.util.List;

public class CompositeDepartment implements DepartmentComponent {
    private final List<DepartmentComponent> children;

    public CompositeDepartment() {
        this.children = new ArrayList<>();
    }

    public void addDepartment(DepartmentComponent department) {
        children.add(department);
    }

    public void removeDepartment(DepartmentComponent department) {
        children.remove(department);
    }

    public List<DepartmentComponent> getAllDepartments() {
        return children;
    }

    public void updateDepartment(DepartmentComponent oldDepartment, DepartmentComponent newDepartment) {
        int index = children.indexOf(oldDepartment);
        if (index != -1) {
            children.set(index, newDepartment);
        }
    }
    @Override
    public String AfficherDepartement() {
        StringBuilder result = new StringBuilder("Composite Department:\n");

        for (DepartmentComponent department : children) {
            result.append(department.AfficherDepartement()).append("\n");
        }

        return result.toString();
    }
}
