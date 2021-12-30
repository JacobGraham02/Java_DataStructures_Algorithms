package Topics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private final static Employee EMPLOYEE_1 = new Employee(1,"Jeff", "Bezos", 100000);
    private final static Employee EMPLOYEE_2 = new Employee(2,"Bill", "Gates", 200000);
    private final static Employee EMPLOYEE_3 = new Employee(3,"Mark", "Zuckerberg", 300000);

    public Stream<Employee> createStreamFromEmployeeArray() {
        return Stream.of(new Employee[]{EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3});
    }

    public Stream createStreamFromList(List list) {
        return list.stream();
    }

    private Employee getEmployeeById(final int employeeId) {
        Employee temp = null;
        for (Employee emp : new Employee[]{EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3}) {
            if (emp.getEmployeeNum() == employeeId) {
                temp = emp;
            }
        }
        if (temp != null) return temp;
        else return new Employee();
    }


     class StreamOperations {
        private final Streams outerStreamsClassReference;
        private List<Employee> employees;

        public StreamOperations() {
            outerStreamsClassReference = new Streams();
//            employees = outerStreamsClassReference.createStreamFromEmployeeArray().collect(Collectors.toList());
        }

        public Streams getOuterStreamsClassReference() {
            return outerStreamsClassReference;
        }

         /**
          * forEach is a terminal operation, which means after the stream pipeline is consumed, it can no longer be used.
          */
        public void forEachMultiplySalaryBy2() {
            getOuterStreamsClassReference().createStreamFromEmployeeArray().forEach(e -> e.setEmployeeSalary(e.getEmployeeSalary() * 2));
        }

         /**
          * Map produces a new stream after applying a function to each element of the origin stream. New stream can be of any type.
          * The chained collect stream operation repackages elements in the stream to another data structure and applies some login on data elements in the
          * Stream instance
          */
         public void mapEmployeeByIdAndCollectToList() {
             Integer[] employeeIds = {1,2,3};
             employees = Stream.of(employeeIds)
                                .map(e -> outerStreamsClassReference.getEmployeeById(employeeIds[0]))
                                .map(e -> outerStreamsClassReference.getEmployeeById(employeeIds[1]))
                                .map(e -> outerStreamsClassReference.getEmployeeById(employeeIds[2]))
                                .collect(Collectors.toList());
             System.out.println(employees);
         }

         /**
          * Filter produces a new stream that contains elements of the origin stream which pass a given test.
          */
         public void filterEmployeesBySalary() {
             Integer[] employeeIds = {1,2,3};
             employees = Stream.of(employeeIds)
                     .map(e -> outerStreamsClassReference.getEmployeeById(employeeIds[1]))
                     .filter(e -> e.getEmployeeSalary() == 200000)
                     .collect(Collectors.toList());
         }

         public void sortNumbersByASCII() {
             List<String> listUnsorted = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
            // naturalOrder orders the elements starting at the lowest ASCII value, and going to the largest
             // reverseOrder orders the elements starting at the highest ASCII value, and going to the lowest
             List<String> listSorted = listUnsorted.stream()
                     .sorted(Comparator.naturalOrder())
                     .collect(Collectors.toList());
             listSorted.forEach(System.out::println);
         }
         public void sortCustomEmployeeObjectBySalary() {
             List<Employee> unsortedEmployeeList = Arrays.asList(EMPLOYEE_2, EMPLOYEE_1, EMPLOYEE_3);
             List<Employee> sortedEmployeeList = unsortedEmployeeList
                     .stream().sorted(Comparator.comparingInt(Employee::getEmployeeSalary))
                    /* .reversed() */
                     .collect(Collectors.toList());

             sortedEmployeeList.forEach(System.out::println);
             // To use the sorted() stream method on a list of custom objects,
         }

         public void countForLengthGreaterThan3() {
             List<String> listStrs = Arrays.asList("abb", "bbb", "cccc", "dd", "yy", "ooooo");
             long numStringsGreaterThan3 = listStrs.stream()
                     .filter(e -> e.length() > 3)
                     .count();
             System.out.println(numStringsGreaterThan3);
         }
    }


    public static Stream<Employee> streamBuilderFromArray() {
        Stream.Builder<Employee> employeeStreamBuilder = Stream.builder();
        employeeStreamBuilder.accept(EMPLOYEE_1);
        employeeStreamBuilder.accept(EMPLOYEE_2);
        employeeStreamBuilder.accept(EMPLOYEE_3);
        return employeeStreamBuilder.build();
    }

    public static void main(String[] args) {
        Streams streams = new Streams();
        Streams.StreamOperations innerStreamOperationsClass = streams.new StreamOperations();
        innerStreamOperationsClass.filterEmployeesBySalary();
        innerStreamOperationsClass.sortNumbersByASCII();
        innerStreamOperationsClass.countForLengthGreaterThan3();

    }
}
