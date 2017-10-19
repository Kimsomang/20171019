package notice.model;

import java.util.Iterator;
import java.util.Set;

import notice.controller.Controller;

public class Service {

	private Controller controller;
	private TestClass test;
	Object ob;
	Set set;
	Iterator<Set> it;
	
	public Service(Set set) {
//		it = set.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		Object[] arr = set.toArray();
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
//		controller = (Controller) it.next();
//		test = (TestClass) it.next();
		
		this.set = set;
	}
	
	
	
	
}
