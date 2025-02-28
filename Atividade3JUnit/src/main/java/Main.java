public class Main {
    public static void main(String[] args) {
        ServicoVeterinario servico = new ServicoVeterinario();

        Animal animal1 = new Animal("Totó", "Cachorro", 8, false);
        Animal animal2 = new Animal("Mimosa", "Gato", 5, false);

        servico.cadastrarAnimal(animal1);
        servico.cadastrarAnimal(animal2);

        Procedimento procedimento1 = new Procedimento("Cirurgia", 500.0, animal1);
        servico.cadastrarProcedimento(procedimento1);

        servico.darAlta("Totó");
    }
}