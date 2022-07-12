package com.company.informationbanksystem.app;

import com.company.informationbanksystem.entity.Account;
import io.jmix.core.DataManager;
import io.jmix.core.SaveContext;
import io.jmix.core.TimeSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component("OperationTestDataCreation")
public class OperationTestDataCreation {
//
//    private static final Logger log = LoggerFactory.getLogger(OperationTestDataCreation.class);
//
//    protected final TimeSource timeSource;
//    protected final DataManager dataManager;
//
//    public OperationTestDataCreation(TimeSource timeSource, DataManager dataManager) {
//        this.timeSource = timeSource;
//        this.dataManager = dataManager;
//    }
//
//    public void createData() {
//
//        if (visitsExists()) {
//            log.info("Account found in DB. Account Test data generation is skipped...");
//            return;
//        }
//        log.info("No Accounts found in the DB. Accounts Test data will be created...");
//        int operationCreatedCount = commit(createOperations());
//        log.info(String.format("%d Accounts created", operationCreatedCount));
//
//    }
//
//    List<Account> createOperations() {
//
//        final Boolean archive;
//        final String name;
//        final currency
//        final List<User> allNurses = employeeRepository.
//        final List<Pet> allPets = list(Pet.class);
//
//        return Stream.concat(
//                        createPastVisits(allPets, allNurses),
//                        createFutureVisits(allPets, allNurses)
//                )
//                .collect(Collectors.toList());
//    }
//
//    private Stream<Visit> createPastVisits(List<Pet> possiblePets, List<User> possibleNurses) {
//        return IntStream.range(0, petclinicTestdataProperties.getVisitStartAmountPastDays())
//                .mapToObj(value -> timeSource.now().minusDays(value).toLocalDate())
//                .map(localDate -> createVisitsForDate(localDate, possiblePets, possibleNurses))
//                .flatMap(Collection::stream)
//                .filter(Objects::nonNull);
//    }
//
//    private Stream<Visit> createFutureVisits(List<Pet> possiblePets, List<User> possibleNurses) {
//        return IntStream.range(1, petclinicTestdataProperties.getVisitStartAmountFutureDays() + 1)
//                .mapToObj(i -> createVisitsForDate(
//                        timeSource.now().plusDays(i).toLocalDate(),
//                        amountForFutureDate(i),
//                        possiblePets,
//                        possibleNurses
//                ))
//                .flatMap(Collection::stream)
//                .filter(Objects::nonNull);
//    }
//
//    private int amountForFutureDate(int i) {
//        int max = petclinicTestdataProperties.getVisitStartAmountFutureDays() + 1;
//        return (int) ((double) (max - i) / max * petclinicTestdataProperties.getAmountPerDay());
//    }
//
//    private List<Visit> createVisitsForDate(LocalDate localDate, List<Pet> possiblePets, List<User> possibleNurses) {
//        return IntStream.range(0, petclinicTestdataProperties.getAmountPerDay())
//                .mapToObj(i -> createVisit(localDate, possiblePets, possibleNurses))
//                .collect(Collectors.toList());
//    }
//
//    private List<Visit> createVisitsForDate(LocalDate localDate, int amount, List<Pet> possiblePets, List<User> possibleNurses) {
//        return IntStream.range(0, amount)
//                .mapToObj(i -> createVisit(localDate, possiblePets, possibleNurses))
//                .collect(Collectors.toList());
//    }
//
//    private boolean visitsExists() {
//        return !list(Visit.class).isEmpty();
//    }
//
//    private int commit(List<Account> operations) {
//        SaveContext saveContext = new SaveContext();
//        operations.forEach(dataManager::save);
//        dataManager.save(saveContext);
//
//        return operations.size();
//    }
//
//    Visit createVisit(
//            LocalDate date,
//            List<Pet> possiblePets,
//            List<User> possibleNurses
//    ) {
//
//        VisitEventRange visitEventRange = randomVisitDateTime.randomVisitEventRange(date);
//
//        if (visitEventRange.isEmpty()) {
//            return null;
//        }
//
//        Visit visit = dataManager.create(Visit.class);
//
//        visit.setTreatmentStatus(treatmentStatusFor(date));
//
//        if (nurseShouldBeAssigned(date)) {
//            visit.setAssignedNurse(randomOfList(possibleNurses));
//        }
//
//        visit.setPet(randomOfList(possiblePets));
//        visit.setType(randomVisitType());
//        visit.setDescription(randomDescription());
//
//        visit.setVisitStart(visitEventRange.getVisitStart());
//        visit.setVisitEnd(visitEventRange.getVisitEnd());
//
//        return visit;
//    }
//
//    private boolean nurseShouldBeAssigned(LocalDate date) {
//        return date.isBefore(timeSource.now().toLocalDate().plusWeeks(1).plusDays(1));
//    }
//
//    private VisitTreatmentStatus treatmentStatusFor(LocalDate date) {
//        final LocalDate today = timeSource.now().toLocalDate();
//        if (date.equals(today)) {
//            return VisitTreatmentStatus.IN_PROGRESS;
//        }
//        else if (date.isAfter(today)) {
//            return VisitTreatmentStatus.UPCOMING;
//        }
//        else {
//            return VisitTreatmentStatus.DONE;
//        }
//    }
//
//    private VisitType randomVisitType() {
//        int pick = random().nextInt(VisitType.values().length);
//        return VisitType.values()[pick];
//    }
//
//    private String randomDescription() {
//        return randomOfList(
//                petclinicTestdataProperties.getDescriptionOptions()
//        ).trim();
//    }
//
//    private Boolean randomArchive(){
//        return random().nextBoolean();
//    }
//
//    private <T> T randomOfList(List<T> list) {
//        if (CollectionUtils.isEmpty(list)) {
//            return null;
//        }
//        return list.get(random().nextInt(list.size()));
//    }
//
//    private Random random() {
//        return new Random();
//    }
//
//    private <T> List<T> list(Class<T> entityClass) {
//        return dataManager.load(entityClass).all().list();
//    }
}
