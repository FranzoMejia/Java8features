package Java;

import java.io.UnsupportedEncodingException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Base64;

public class Java {

	public static void main(String[] args) {
		System.out.println("Hola Mundo");
		//LambdaExp();
		//MethodReference();
		//Streams();
		//OptionalClass();
		//DateTimeApi();
		Base64();
	}
	
	private static void Base64() {
		try {
			
	         // Encode using basic encoder
	         String base64encodedString = Base64.getEncoder().encodeToString(
	            "TutorialsPoint?java8".getBytes("utf-8"));
	         System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);
			
	         // Decode
	         byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
			
	         System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
	         base64encodedString = Base64.getUrlEncoder().encodeToString(
	            "TutorialsPoint?java8".getBytes("utf-8"));
	         System.out.println("Base64 Encoded String (URL) :" + base64encodedString);
			
	         StringBuilder stringBuilder = new StringBuilder();
			
	         for (int i = 0; i < 10; ++i) {
	            stringBuilder.append(UUID.randomUUID().toString());
	         }
			
	         byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
	         String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
	         System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);

	      } catch(UnsupportedEncodingException e) {
	         System.out.println("Error :" + e.getMessage());
	      }
		
	}

	private static void DateTimeApi() {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date1 = currentTime.toLocalDate();
		Month  month = currentTime.getMonth(); 
		
		System.out.println(currentTime);
		System.out.println(date1);
		System.out.println(month);
		
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2020);
		System.out.println(date2);
		
		LocalTime time1 = LocalTime.of(16,00);
		System.out.println(time1);
		
	     // Get the current date and time
	      ZonedDateTime date3 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
	      System.out.println("date1: " + date3);
			
	      ZoneId id = ZoneId.of("Europe/Paris");
	      System.out.println("ZoneId: " + id);
			
	      ZoneId currentZone = ZoneId.systemDefault();
	      System.out.println("CurrentZone: " + currentZone);
	      
	      //ChronoUnit
	      
	      LocalDateTime today = LocalDateTime.now();
	      System.out.println(today.plusHours(2));
	      System.out.println(today.plus(1,ChronoUnit.DAYS));
	      
	      LocalDateTime ayer = today.plusDays(-1);
	      
	      System.out.println(ayer.compareTo(today));
	      	
	      
	      //Get the current date
	      LocalDate date11 = LocalDate.now();
	      System.out.println("Current date: " + date1);
			
	      //add 1 month to the current date
	      LocalDate date22 = date11.plus(1, ChronoUnit.MONTHS);
	      System.out.println("Next month: " + date22);
	      
	      Period period = Period.between(date22, date11);
	      System.out.println("Period: " + period.getMonths());
	      
	      LocalTime time11 = LocalTime.now();
	      Duration twoHours = Duration.ofHours(2);
			
	      LocalTime time22 = time11.plus(twoHours);
	      Duration duration = Duration.between(time11, time22);
			
	      System.out.println("Duration: " + duration.get(ChronoUnit.SECONDS));
	      LocalDate date1ta = LocalDate.now();
	      System.out.println("Current date: " + date1ta);
			
	      //get the next tuesday
	      LocalDate nextTuesday = date1ta.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
	      System.out.println("Next Tuesday on : " + nextTuesday);
			
	      //get the second saturday of next month
	      LocalDate firstInYear = LocalDate.of(date1ta.getYear(),date1ta.getMonth(), 1);
	      LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(
	         DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
	      System.out.println("Second Saturday on : " + secondSaturday);
	      
	      
		
		
	}

	private static void OptionalClass() {
		Integer v1= null;
		Integer v2 = Integer.valueOf(10);
		
		Optional<Integer> a = Optional.ofNullable(v1);
		Optional<Integer> b = Optional.of(v2);
		System.out.println(sum(a,b));
		
	}
	
	public static Integer sum(Optional<Integer> a,Optional<Integer> b)
	{	
		System.out.println("a:"+ a.isPresent());
		System.out.println("b:"+ b.isPresent());
		
		Integer value1= a.orElse(0);
		Integer value2= b.get();
		
		return value1+value2;

	}

	static class Auto{
		private String marca;
		private String modelo;
		
		public Auto(String marca, String modelo) {
			super();
			this.marca = marca;
			this.modelo = modelo;
		}
		
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
	}

	private static void Streams() {
		List<String> strings = Arrays.asList("Jazmin","Fran","","Alber");
		List<Auto> autos = new ArrayList<Auto>();
		autos.add(new Auto("Seat", "2013"));
		autos.add(new Auto("Jeep", "2013"));
		autos.add(new Auto("Corolla", "2016"));
		
		List<Auto> autosNuevos = autos.stream().filter(string-> string.getModelo()!="2013").collect(Collectors.toList());
		List<String> filter = strings.stream().filter(string-> !string.isEmpty()).collect(Collectors.toList());
		Optional<String> filter2 = strings.stream().findFirst();
		List<String> filter3 = strings.stream().filter(string-> string.equals("Fran")).collect(Collectors.toList());
		
		//forEach en Stream
		autos.stream().forEach(auto->
		{
			System.out.println("Marca:"+auto.getMarca());
			System.out.println("Marca:"+auto.getModelo());
			
		});
		//Random es un Stream 
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		random.ints().limit(10).sorted().forEach(System.out::println);
		
	
		//Map
		List<Integer> integers = Arrays.asList(2,2,3,5,7);
		Collections.sort(integers,Comparator.reverseOrder());
		List<Integer> square = integers.stream().map(n->n*n).distinct().collect(Collectors.toList());
		
		
		List<String>strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings2.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	}

	private static void MethodReference() {
		List names= new ArrayList();
		
		names.add("Juana");
		names.add(1);
		 names.forEach(System.out::print);
		
	}

	public static void LambdaExp() {
		
		Java java= new Java();
		//With type declaration
		MathOperation addition= (int a, int b)->a+b; 
		
		//whit out type declaration
		MathOperation substraction=(a,b)->a-b;
		
		//whit return statement alogn with curly braces
		MathOperation multiplication=(a,b)->{return a*b;};
		
		//whitout return statement an whitout curly braces
		MathOperation division=(a,b)->a/b;
		
		System.out.println(java.operate(5, 20, addition));
		System.out.println(java.operate(5, 20, substraction));
		System.out.println(java.operate(5, 20, multiplication));
		System.out.println(java.operate(5, 20, division));
		
		//whithout parentesis
		GreetingService gree1 = a->System.out.println(a);
		
		//whit parentesis
		GreetingService gree2 =(mes)->System.out.println(mes);
		
		gree1.sayMessage("Hello world");
		gree2.sayMessage("Hola desde serv");
		
	

		
	}
	
	interface MathOperation{
		int operation(int a, int b);
	}
	
	interface GreetingService{
		void sayMessage(String message);
	};
	
	private int operate(int a, int b, MathOperation mathOperation) {
	      return mathOperation.operation(a, b);
	   }

}
