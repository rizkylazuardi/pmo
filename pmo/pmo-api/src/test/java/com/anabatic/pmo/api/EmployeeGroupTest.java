package com.anabatic.pmo.api;

import java.util.Date;
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

import com.anabatic.pmo.businesslogic.validator.api.IEmployeeGroupValidator;
import com.anabatic.pmo.core.enumeration.DataStatusEnum;
import com.anabatic.pmo.persistence.entity.EmployeeGroup;
import com.anabatic.pmo.service.api.EmployeeGroupService;

/**
 * 
 * @author rizky.lazuardi junit run berdasarkan urutan nama method, nama method
 *         diberi prefix alphabet agar mudah membaca sorting
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml",
		"classpath:applicationContext-businesslogic-test.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeGroupTest {
	@Autowired
	private EmployeeGroupService service;

	@Autowired
	@Qualifier("groupValidator")
	private IEmployeeGroupValidator validator;

	EmployeeGroup dataAdd = new EmployeeGroup();
	EmployeeGroup dataEdit = new EmployeeGroup();

	public void beforeAdd() {
		dataAdd.setName("Backend");
		dataAdd.setDescription("Backend System Developer");
		dataAdd.setDescriptionEn("Backend System Developer");
		dataAdd.setCreatedBy("Orang ganteng");
		dataAdd.setCreatedTime(new Date());
		dataAdd.setStatus(DataStatusEnum.LIVE.name());
	}

	public void beforeEdit() {
		dataEdit.setId(171L);
		dataEdit.setName("Backend");
		dataEdit.setDescription("Backend System Developer EDIT");
		dataEdit.setDescriptionEn("Backend System Developer EDIT");
		dataEdit.setUpdatedBy("Orang ganteng EDIT");
		dataEdit.setUpdatedTime(new Date());
		dataEdit.setStatus(DataStatusEnum.LIVE.name());
	}

	@Before
	public void init() {
		service.openDB();

		// inisialisasi object
		beforeAdd();
		beforeEdit();
	}

	@Test
	public void a_insert() {
		try {
			validator.validate(dataAdd);
			if (!validator.hasError()) {
				service.insert(dataAdd);
				// check inserted data
				EmployeeGroup insertedData = service.getByName(dataAdd);
				MatcherAssert.assertThat(insertedData.getName(),
						Matchers.equalTo(dataAdd.getName()));
				MatcherAssert.assertThat(insertedData.getDescription(),
						Matchers.equalTo(dataAdd.getDescription()));
				MatcherAssert.assertThat(insertedData.getDescriptionEn(),
						Matchers.equalTo(dataAdd.getDescriptionEn()));
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
	public void b_testFindAll() {
		try {
			List<EmployeeGroup> listGroup = service
					.findAll(new EmployeeGroup());
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
	public void c_testFindById() {
		try {
			EmployeeGroup param = new EmployeeGroup();
			param.setId(165L);

			EmployeeGroup data = service.getById(param);
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
	public void d_update() {
		try {
			validator.validateEdit(dataEdit);
			if (!validator.hasError()) {
				service.insert(dataEdit);
				// check inserted data
				EmployeeGroup updatedData = service.getByName(dataEdit);
				MatcherAssert.assertThat(updatedData.getName(),
						Matchers.equalTo(dataEdit.getName()));
				MatcherAssert.assertThat(updatedData.getDescription(),
						Matchers.equalTo(dataEdit.getDescription()));
				MatcherAssert.assertThat(updatedData.getDescriptionEn(),
						Matchers.equalTo(dataEdit.getDescriptionEn()));
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
	public void e_softDelete() {
		try {
			EmployeeGroup dataDelete = new EmployeeGroup();
			dataDelete.setId(171L);

			service.softDelete(dataDelete);

			EmployeeGroup group = service.getById(dataDelete);
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

	@After
	public void finaly() {
		service.closeDB();
	}

}
