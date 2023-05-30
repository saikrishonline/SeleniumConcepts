import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamsDemo {

	public static void main(String[] args) {
		
		//getSpecificNames();
	//	getSpecificNamesWithStreams();
	//	streamMaps();
		//streamConcat();
		//collectList();
		integerSort();

	}
	
	
	public static void getSpecificNames() {
		
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("Sai");
		al.add("Swetha");
		al.add("Appu");
		al.add("Shreyas");
		al.add("Sai Aaradhya");
		al.add("Kriti");
		
		int count =0;
		
		for(int i=0; i<al.size(); i++) {
			
			String output = al.get(i);
			if(output.startsWith("S")) {
				
				count++;
				
			}
			
			
		}
		
		
		System.out.println(count);
		
	}
	
	
	public static void getSpecificNamesWithStreams() {
		
		

		ArrayList<String> al = new ArrayList<String>();
		al.add("Sai");
		al.add("Swetha");
		al.add("Appu");
		al.add("Shreyas");
		al.add("Sai Aaradhya");
		al.add("Kriti");
		
		//There is no life for intermediate operation if there is no terminal operation
		//Terminal operation will execute only if intermediate operation returns true

	
		int count = (int) al.stream().filter(obj->obj.startsWith("S")).count();	
		
		//printing stream of names with greater than 4 characters
		al.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//printing only the first match with 
		al.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		String firstName = al.stream().filter(s->s.length()>4).findFirst().get();
		System.out.println(firstName);
		
		
		System.out.println(count);
		
		long count1 = Stream.of("Arav", "Appu", "Sai", "Air").filter(obj->
		{
			return obj.startsWith("A");
			
		
		}).count();
		
		System.out.println(count1);
		
		//printing all names 
		
	 	 Stream.of("Arav", "Appu", "Sai", "Air").filter(obj->
		{
			return true;
			
		
		}).forEach(obj->System.out.println(obj));
		
		
		
	}
	
	
	public static void streamMaps() {
		
		Stream.of("Zaradhya","Sai","Sachin","Krishna","Kriti").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		Stream.of("Zaradhya","Sai","Sachin","Krishna","Kriti").filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}
	
	
	public static void streamConcat() {
		
		String[] name = {"Rama", "Sai", "Krishna"};
		
		List<String> nameList = Arrays.asList(name);
		
	
		
		ArrayList<String> newList = new ArrayList<>();
		newList.add("Priya");
		newList.add("Swetha");
		newList.add("Radha");
		newList.add("Sweety");
		
		
		
		
		//Concat 2 arraylist into a new stream
		
		Stream<String> newStreamConcat = Stream.concat(nameList.stream(), newList.stream());
		
		List<String> newStreamConcat1 = Stream.concat(nameList.stream(), newList.stream()).collect(Collectors.toList());
		for(String newStreamCon : newStreamConcat1) {
			System.out.println(newStreamCon);
			
		}
		
		
		
		boolean isPresent = newStreamConcat.anyMatch(s->s.equalsIgnoreCase("Radha"));
		System.out.println(isPresent);
		Assert.assertTrue(isPresent);
	}
	
	
	public static void collectList() {
		
		
		List<String> list = Stream.of("Sai", "Aaradhya", "Samhita", "Shreshta").sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		Character output = list.get(0).toLowerCase().charAt(1);
		System.out.println(output);
		
	}
	
	public static void integerSort() {
		
		List<Integer> numbers =  Arrays.asList(3,2,2,7,5,1,9,7);
		Stream<Integer> removeDuplicated = numbers.stream().distinct();
		//prints distinct numbers by removing duplicates
	//	removeDuplicated.forEach(s->System.out.print(s));
		
		
	int num=	numbers.stream().distinct().sorted().collect(Collectors.toList()).get(2);
		System.out.println(num);
		
	}

}
