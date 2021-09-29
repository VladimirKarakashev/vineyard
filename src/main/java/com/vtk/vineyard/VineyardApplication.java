package com.vtk.vineyard;

import com.vtk.vineyard.model.Culture;
import com.vtk.vineyard.model.Operation;
import com.vtk.vineyard.model.Phenophase;
import com.vtk.vineyard.repositoy.CultureRepo;
import com.vtk.vineyard.util.CalendarGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class VineyardApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(VineyardApplication.class, args);

		CultureRepo cultureRepo = configurableApplicationContext.getBean(CultureRepo.class);

		Culture culture = new Culture(1L, "Лоза", "vine", "vine_basics");

		Phenophase pheno0 = new Phenophase(
				1L,
				"Януари",
				"pheno_jan",
				"jan_practice",
				culture
		);

		Phenophase pheno1 = new Phenophase(
				2L,
				"Февруари",
				"pheno_feb",
				"feb_practice",
				culture
		);

		Phenophase pheno2 = new Phenophase(
				3L,
				"Март",
				"pheno_mar",
				"mar_practice",
				culture
		);

		Phenophase pheno3 = new Phenophase(
				4L,
				"Април",
				"pheno_apr",
				"apr_practice",
				culture
		);

		Phenophase pheno4 = new Phenophase(
				5L,
				"Май",
				"pheno_may",
				"may_practice",
				culture
		);

		Phenophase pheno5 = new Phenophase(
				6L,
				"Юни",
				"pheno_jun",
				"jun_practice",
				culture
		);

		Phenophase pheno6 = new Phenophase(
				7L,
				"Юли",
				"pheno_jul",
				"jul_practice",
				culture
		);

		Phenophase pheno7 = new Phenophase(
				8L,
				"Август",
				"pheno_aug",
				"aug_practice",
				culture
		);

		Phenophase pheno8 = new Phenophase(
				9L,
				"Септември",
				"pheno_sep",
				"sep_practice",
				culture
		);

		Phenophase pheno9 = new Phenophase(
				10L,
				"Октомври",
				"pheno_oct",
				"oct_practice",
				culture
		);

		Phenophase pheno10 = new Phenophase(
				11L,
				"Ноември",
				"pheno_nov",
				"nov_practice",
				culture
		);

		Phenophase pheno11 = new Phenophase(
				12L,
				"Декември",
				"pheno_dec",
				"dec_practice",
				culture
		);

		List<Phenophase> phenophaseList = Arrays.asList(
				pheno0, pheno1, pheno2, pheno3, pheno4, pheno5,
				pheno6, pheno7, pheno8, pheno9, pheno10, pheno11
		);

		Operation operation0 = new Operation(
				1L,
				LocalDate.of(2021,1,9),
				"Подрязване",
				12.90f,
				4,
				culture
		);

		Operation operation1 = new Operation(
				2L,
				LocalDate.of(2021,1,12),
				"Загърляне",
				15.30f,
				2,
				culture
		);

		Operation operation2 = new Operation(
				3L,
				LocalDate.of(2021,2,9),
				"Плевене",
				5.00f,
				3,
				culture
		);

		Operation operation3 = new Operation(
				4L,
				LocalDate.of(2021,2,15),
				"Подрязване",
				12.90f,
				4,
				culture
		);

		Operation operation4 = new Operation(
				5L,
				LocalDate.of(2021,3,13),
				"Пръскане, болести",
				25.30f,
				2,
				culture
		);

		Operation operation5 = new Operation(
				6L,
				LocalDate.of(2021,4,15),
				"Плевене",
				5.00f,
				3,
				culture
		);

		Operation operation6 = new Operation(
				7L,
				LocalDate.of(2021,4,20),
				"Подрязване",
				0.00f,
				6,
				culture
		);

		Operation operation7 = new Operation(
				8L,
				LocalDate.of(2021,5,11),
				"Търсене на болести",
				0.00f,
				4,
				culture
		);

		Operation operation8 = new Operation(
				9L,
				LocalDate.of(2021,5,14),
				"Пръскане, болести",
				16.50f,
				4,
				culture
		);

		Operation operation9 = new Operation(
				10L,
				LocalDate.of(2021,6,9),
				"Търсене на вредители",
				5.50f,
				8,
				culture
		);

		Operation operation10 = new Operation(
				11L,
				LocalDate.of(2021,7,19),
				"Търсене на вредители",
				0.00f,
				5,
				culture
		);

		Operation operation11 = new Operation(
				12L,
				LocalDate.of(2021,8,8),
				"Плевене",
				0.00f,
				3,
				culture
		);

		List<Operation> operationList = Arrays.asList(
				operation0, operation1, operation2,
				operation3, operation4, operation5,
				operation6, operation7, operation8,
				operation9, operation10, operation11
		);

		culture.setPhenophases(phenophaseList);
		culture.setOperations(operationList);
		cultureRepo.save(culture);

		System.out.println(java.time.LocalDate.now());
        System.out.println( "Today is: "
                + CalendarGenerator.generateDayIndex()
                + "."
                + CalendarGenerator.generateMonthIndex()
                + "."
                + CalendarGenerator.generateYearIndex()
        );
	}
}
