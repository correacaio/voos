import java.util.List;

public record ResumoVoo(
    String origem,
    String destino,
    Double vooMaisRapido,
    Double vooMaisLongo,
    Double vooMaisBarato,
    Double tempoMedio,
    Double precoMedio
) {

    public ResumoVoo(List<Voo> voos) {
        this(voos.get(0).origem(), voos.get(0).destino(), voos);
    }

    public ResumoVoo(String origem, String destino, List<Voo> voos) {
        this(
            origem,
            destino,
            voos.stream().mapToDouble(Voo::tempoDeVoo).min().getAsDouble(),
            voos.stream().mapToDouble(Voo::tempoDeVoo).max().getAsDouble(),
            voos.stream().mapToDouble(Voo::preco).min().getAsDouble(),
            voos.stream().mapToDouble(Voo::tempoDeVoo).average().getAsDouble(),
            voos.stream().mapToDouble(Voo::preco).average().getAsDouble()
        );
    }

    @Override
    public String toString() {
        return String.format(
            "%s;%s;%s;%s;%s;%s;%s",
            origem,
            destino,
            vooMaisRapido.toString(),
            vooMaisLongo.toString(),
            vooMaisBarato.toString(),
            tempoMedio.toString(),
            precoMedio.toString()
        );
    }
}
