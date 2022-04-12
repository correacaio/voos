import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Voo> voos = carregaVoos();
        geraArquivo1(voos.stream());
        geraArquivo2(voos.stream());
    }

    public static List<Voo> carregaVoos() throws IOException {
        return Files.lines(Path.of("voos.csv"))
            .skip(1)
            .map(Voo::new)
            .toList();
    }

    public static void geraArquivo1(Stream<Voo> voos) throws IOException {
        List<String> voosOrdenados = voos.sorted(
                Comparator
                    .comparing(Voo::origem)
                    .thenComparing(Voo::destino)
                    .thenComparing(Voo::tempoDeVoo)
                    .thenComparing(Voo::preco)
                    .thenComparing(Voo::companhia)
            )
            .map(Voo::toString)
            .collect(Collectors.toList());

        voosOrdenados.add(0, "origin;destination;airline;departure;arrival;price;time");
        Files.write(Path.of("arquivo-saida-1.csv"), voosOrdenados);
    }

    public static void geraArquivo2(Stream<Voo> voos) throws IOException {
        List<String> resumoVoos = voos
            .collect(Collectors.groupingBy(voo -> voo.origem() + voo.destino()))
            .values()
            .stream()
            .map(ResumoVoo::new)
            .map(ResumoVoo::toString)
            .collect(Collectors.toList());

        resumoVoos.add(0, "origin;destination;shortest_flight(h);longest_fight(h);cheapest_flight;most_expensive_flight;average_time;average_price");
        Files.write(Path.of("arquivo-saida-2.csv"), resumoVoos);
    }
}
