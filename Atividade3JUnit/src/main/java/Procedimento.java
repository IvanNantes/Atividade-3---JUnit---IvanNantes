import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Procedimento {
    private String descricao;
    private double preco;
    private Animal animal;
}