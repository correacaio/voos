import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public record Voo(
    String origem,
    String destino,
    String companhia,
    OffsetDateTime horarioPartida,
    OffsetDateTime horarioChegada,
    Double preco
) {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss (XXX)");
    private static final String DELIMITADOR = ";";

    public Voo(String[] values) {
        this(
            values[0],
            values[1],
            values[2],
            OffsetDateTime.parse(values[3], FORMATTER),
            OffsetDateTime.parse(values[4], FORMATTER),
            Double.valueOf(values[5])
        );
    }

    public Voo(String linha) {
        this(linha.split(DELIMITADOR));
    }

    public Double tempoDeVoo() {
        return BigDecimal.valueOf(horarioPartida.until(horarioChegada, ChronoUnit.MINUTES))
            .divide(new BigDecimal("60"))
            .doubleValue();
    }

    @Override
    public String toString() {
        return String.format(
            "%s;%s;%s;%s;%s;%s;%s",
            origem,
            destino,
            companhia,
            FORMATTER.format(horarioPartida),
            FORMATTER.format(horarioChegada),
            preco.toString(),
            tempoDeVoo()
        );
    }
}
