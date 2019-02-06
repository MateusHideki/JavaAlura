package lambda;
import java.util.function.Consumer;

public class ImprimePorLinha implements Consumer<String>{

	public void accept(String s) {
		System.out.println(s);
	}

}
