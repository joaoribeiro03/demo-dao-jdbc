package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n=== TESTE 1: department insert ===");
		Department newDepartment = new Department(null, "Novo Departamento");
		departmentDao.insert(newDepartment);
		System.out.println("Novo departamento inserido: " + newDepartment);

		System.out.println("\n=== TESTE 2: department delete ===");
		System.out.println("Digite o id para deletar um departamento: ");
		int idToDelete = sc.nextInt();
		departmentDao.deleteById(idToDelete);
		System.out.println("Departamento deletado com sucesso.");

		System.out.println("\n=== TESTE 3: department findById ===");
		System.out.println("Digite o id para buscar um departamento: ");
		int idToFind = sc.nextInt();
		Department dep = departmentDao.findById(idToFind);
		if (dep != null) {
			System.out.println("Departamento encontrado: " + dep);
		} else {
			System.out.println("Departamento não encontrado.");
		}

		System.out.println("\n=== TESTE 4: department update ===");
		System.out.println("Digite o id para atualizar o departamento: ");
		int idToUpdate = sc.nextInt();
		Department department = departmentDao.findById(idToUpdate);
		if (department != null) {
			sc.nextLine();
			System.out.println("Digite o novo nome para o departamento: ");
			String newName = sc.nextLine();
			department.setName(newName);
			departmentDao.update(department);
			System.out.println("Departamento atualizado com sucesso.");
		} else {
			System.out.println("Departamento não encontrado para atualização.");
		}

		System.out.println("\n=== TESTE 5: department findAll ===");
		List<Department> departments = departmentDao.findAll();
		for (Department d : departments) {
			System.out.println(d);
		}

		sc.close();
	}
}
