package reactivejava;

import io.reactivex.Observable;

public class FirstExample {
	
	public void emit() {
		Observable.just("Hello", "RxJava 2!!", "And Android!")
		//.subscribe(System.out::println);
		.subscribe(data -> System.out.println(data)); // Same thing as .subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		FirstExample demo = new FirstExample();
		demo.emit();
	}

}
