package lambda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
	public static void main(String[] args) {
		//lista de string
		List<String> palavras = new ArrayList<String>();
		palavras.add("Aenean");
		palavras.add("venenatis");
		palavras.add("diam");
		
		//utlizando classes propria para implementar o consumer e comparator
		ImprimePorLinha consumer = new ImprimePorLinha();
		ComparaTamanho comparator = new ComparaTamanho();
		
		palavras.sort(comparator);
		palavras.forEach(consumer);
		
		palavras.forEach(s -> System.out.println(s));
		palavras.sort((s1,s2)->comparator.compare(s1, s2));
		
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length()); 
		});
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));

		palavras.forEach(System.out::println);
		
		//lista de cursos
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		//sort usando lambda
		cursos.sort(Comparator.comparingInt(s -> s.getAlunos()));
		//sort usando method reference
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));

		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));
		cursos.stream().map(c -> c.getNome());

		//filtra os cursos com mais de 50 alunas, mapeia apenas pelos alunos e faz um sysout em cada um da colecao
		cursos.stream().filter(c -> c.getAlunos() > 50).map(c -> c.getAlunos()).forEach(x -> System.out.println(x));

		//por method reference
		cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getAlunos).forEach(System.out::println);

		//primerio elemento
		cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();

		//retorna a media de alunos
		cursos.stream().mapToInt(c -> c.getAlunos()).average().getAsDouble();

		Stream<Curso> stream = cursos.stream().filter(c -> c.getAlunos() > 50);
		//transforma o stream em lista
		List<Curso> cursosFiltrados = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());

		
		
	}
}
