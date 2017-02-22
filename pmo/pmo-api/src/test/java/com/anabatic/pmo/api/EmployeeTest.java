package com.anabatic.pmo.api;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anabatic.pmo.businesslogic.validator.api.IEmployeeValidator;
import com.anabatic.pmo.persistence.entity.Employee;
import com.anabatic.pmo.service.api.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml",
		"classpath:applicationContext-businesslogic-test.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeTest {
	@Autowired
	private EmployeeService service;

	@Autowired
	@Qualifier("EmployeeValidator")
	private IEmployeeValidator validator;

	Employee dataAdd = new Employee();
	Employee dataEdit = new Employee();

	public void beforeAdd() {
		dataAdd.setName("diyaz");
		dataAdd.setNik("54321");
		dataAdd.setTitle("pelajar");
		dataAdd.setGrupId("123");
		dataAdd.setCity("tangerang");
		dataAdd.setPostal_code("3451");
		dataAdd.setProvince("Jawa Barat");
		dataAdd.setStreet_adress1("jl.jawa");
		dataAdd.setStreet_adress2("jl.bali");
		dataAdd.setNickname("ahmad");
		dataAdd.setUsername("wati");
	}

	public void beforeEdit() {
		dataEdit.setId(111L);
		dataEdit.setName("diyaz");
		dataEdit.setNik("54321");
		dataEdit.setTitle("pelajar");
		dataEdit.setGrupId("123");
		dataEdit.setCity("tangerang");
		dataEdit.setPostal_code("5431");
		dataEdit.setProvince("jawa Barat");
		dataEdit.setStreet_adress1("jl.jawa");
		dataEdit.setStreet_adress2("jl.bali");
		dataEdit.setNickname("ahmad");
		dataEdit.setUsername("wati");
	}

	@Before
	public void init() {
		service.openDB();
		// inisialisasi object
		beforeAdd();
		beforeEdit();
	}

	@Test
	public void insert_Employee() {
		try {
			validator.validate(dataAdd);
			if (!validator.hasError()) {
				service.insert(dataAdd);
				// check inserted data
				Employee insertedData = service.getEmployeeByName(dataAdd);
				MatcherAssert.assertThat(insertedData.getName(),
						Matchers.equalTo(dataAdd.getName()));
				MatcherAssert.assertThat(insertedData.getNik(),
						Matchers.equalTo(dataAdd.getNik()));
				MatcherAssert.assertThat(insertedData.getTitle(),
						Matchers.equalTo(dataAdd.getTitle()));
				MatcherAssert.assertThat(insertedData.getGrupId(),
						Matchers.equalTo(dataAdd.getGrupId()));
				MatcherAssert.assertThat(insertedData.getCity(),
						Matchers.equalTo(dataAdd.getCity()));
				MatcherAssert.assertThat(insertedData.getPostal_code(),
						Matchers.equalTo(dataAdd.getPostal_code()));
				MatcherAssert.assertThat(insertedData.getProvince(),
						Matchers.equalTo(dataAdd.getProvince()));
				MatcherAssert.assertThat(insertedData.getStreet_adress1(),
						Matchers.equalTo(dataAdd.getStreet_adress1()));
				MatcherAssert.assertThat(insertedData.getStreet_adress2(),
						Matchers.equalTo(dataAdd.getStreet_adress2()));
				MatcherAssert.assertThat(insertedData.getNickname(),
						Matchers.equalTo(dataAdd.getNickname()));
				MatcherAssert.assertThat(insertedData.getUsername(),
						Matchers.equalTo(dataAdd.getUsername()));

			} else {
				// show in junit error
				for (String key : validator.getErrors().keySet()) {
					Assert.fail(validator.getErrors().get(key)
							.getDefaultMessage());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value
		}
	}

	@Test
	public void updateEmployee() {
		try {
			validator.validate(dataEdit);
			if (!validator.hasError()) {
				service.insert(dataEdit);
				// check inserted data
				Employee updatedData = service.getEmployeeByName(dataAdd);
				MatcherAssert.assertThat(updatedData.getName(),
						Matchers.equalTo(dataEdit.getName()));
				MatcherAssert.assertThat(updatedData.getNik(),
						Matchers.equalTo(dataEdit.getNik()));
				MatcherAssert.assertThat(updatedData.getTitle(),
						Matchers.equalTo(dataEdit.getTitle()));
				MatcherAssert.assertThat(updatedData.getGrupId(),
						Matchers.equalTo(dataEdit.getGrupId()));
				MatcherAssert.assertThat(updatedData.getCity(),
						Matchers.equalTo(dataEdit.getCity()));
				MatcherAssert.assertThat(updatedData.getPostal_code(),
						Matchers.equalTo(dataEdit.getPostal_code()));
				MatcherAssert.assertThat(updatedData.getProvince(),
						Matchers.equalTo(dataEdit.getProvince()));
				MatcherAssert.assertThat(updatedData.getStreet_adress1(),
						Matchers.equalTo(dataEdit.getStreet_adress1()));
				MatcherAssert.assertThat(updatedData.getStreet_adress2(),
						Matchers.equalTo(dataEdit.getStreet_adress2()));
				MatcherAssert.assertThat(updatedData.getNickname(),
						Matchers.equalTo(dataEdit.getNickname()));
				MatcherAssert.assertThat(updatedData.getUsername(),
						Matchers.equalTo(dataEdit.getUsername()));

			} else {
				// show in junit error
				for (String key : validator.getErrors().keySet()) {
					Assert.fail(validator.getErrors().get(key)
							.getDefaultMessage());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value

		}
	}

	@Test
	public void testFindAll() {
		try {
			List<Employee> listGroup = service.findAll(new Employee());
			MatcherAssert.assertThat(listGroup.size(), Matchers.greaterThan(0));
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value
		}
	}

	@Test
	public void testEmployeeByUsernameAndGrup() {
		try {
			Employee param = new Employee();
			param.setId(165L);

			Employee data = service.getEmployeeByUsernameAndGrup(param);
			if (data == null) {
				Assert.fail("Employee not found , or you have not change paramter id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value

		}

	}

	@Test
	public void testEmployeeByProject() {
		try {
			Employee param = new Employee();
			param.setId(165L);

			Employee data = service.getEmployeByProject(param);
			if (data == null) {
				Assert.fail("Employee Group not found , or you have not change paramter id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value

		}
	}

	@Test
	public void testEmployeeById() {
		try {
			Employee param = new Employee();
			param.setId(165L);

			Employee data = service.getEmployeeById(param);
			if (data == null) {
				Assert.fail("Employee Group not found , or you have not change paramter id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value

		}
	}

	@Test
	public void updateSoftDelete() {
		try {
			Employee dataDelete = new Employee();
			dataDelete.setId(171L);

			service.softDelete(dataDelete);

			Employee group = service.getEmployeeById(dataDelete);
			if (group != null) {
				Assert.fail("Delete data failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value
		}

	}

	@Test
	public void testEmployeeByName() {
		try {
			Employee param = new Employee();
			param.setId(165L);

			Employee data = service.getEmployeeByName(param);
			if (data == null) {
				Assert.fail("Employee Group not found , or you have not change paramter id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));// we expect
																// that object e
																// = null or
																// there is no
																// exception
																// value

		}
	}

	@After
	public void finaly() {
		service.closeDB();
	}
}