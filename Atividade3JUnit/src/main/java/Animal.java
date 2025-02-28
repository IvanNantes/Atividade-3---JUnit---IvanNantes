import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private boolean internado;
}