import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ServicoVeterinario {

    @Setter
    @Getter
    private List<Animal> listaAnimais;

    @Setter
    @Getter
    private List<Procedimento> listaProcedimentos;

    public ServicoVeterinario() {
        this.listaAnimais = new ArrayList<>();
        this.listaProcedimentos = new ArrayList<>();
    }

    public void cadastrarAnimal(Animal animal) {
        listaAnimais.add(animal);
    }

    public void darAlta(String nomeAnimal) {
        for (Animal animal : listaAnimais) {
            if (animal.getNome().equalsIgnoreCase(nomeAnimal) && animal.isInternado()) {
                animal.setInternado(false);
                return;
            }
        }
    }

    public void cadastrarProcedimento(Procedimento procedimento) {
        listaProcedimentos.add(procedimento);
        procedimento.getAnimal().setInternado(true);
    }
}