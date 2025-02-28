import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteServicoVeterinario {

    private Animal animal1;
    private Animal animal2;
    private Procedimento procedimento1;
    private ServicoVeterinario servicoVeterinario;

    @Before
    public void setUp() {
        servicoVeterinario = new ServicoVeterinario();
        
        animal1 = new Animal("Totó", "Cachorro", 8, false);
        animal2 = new Animal("Mimosa", "Gato", 5, false);
    }

    @Test 
    public void testeCadastroAnimal() {
    	
    	// Lista deve estar vazia
        Assert.assertTrue(servicoVeterinario.getListaAnimais().isEmpty());

        // Cadastro de Totó
        servicoVeterinario.cadastrarAnimal(animal1);

        // Lista agora tem 1 animal cadastrado
        Assert.assertEquals(1, servicoVeterinario.getListaAnimais().size());
        
        //O primeiro animal da lista se chama Totó
        Assert.assertEquals("Totó", servicoVeterinario.getListaAnimais().get(0).getNome()); 
    }

    @Test
    public void testeDarAltaAnimal() {
    	
    	// Totó cadastrado
        servicoVeterinario.cadastrarAnimal(animal1);
        
        // Criação do procedimento Vacinação
        procedimento1 = new Procedimento("Vacinação", 150.0, animal1);
        
        // Vacinação cadastrada
        servicoVeterinario.cadastrarProcedimento(procedimento1);
        
        // Verifica se o Totó está internado
        Assert.assertTrue(animal1.isInternado());

        // Da alta pro Totó
        servicoVeterinario.darAlta("Totó");
        
        // Verifica se Totó não está mais internado
        Assert.assertFalse(animal1.isInternado());
    }

    @Test
    public void testeCadastroProcedimento() {
    	
    	// Cadastra Totó
        servicoVeterinario.cadastrarAnimal(animal1);

        // Cria o procedimento Exame de sangue
        procedimento1 = new Procedimento("Exame de sangue", 120.0, animal1);
        
        // Exame de sangue cadastrado
        servicoVeterinario.cadastrarProcedimento(procedimento1);

        // Verifica se o procedimento foi adicionado a lista
        Assert.assertEquals(1, servicoVeterinario.getListaProcedimentos().size());
        
        // Verifica se Totó está internado
        Assert.assertTrue(animal1.isInternado());
    }

    @Test
    public void testeCadastroMultiplosAnimais() {
    	
    	// Cadastra Totó e Mimosa
        servicoVeterinario.cadastrarAnimal(animal1);
        servicoVeterinario.cadastrarAnimal(animal2);

        // Verifica se os dois animais foram cadastrados
        Assert.assertEquals(2, servicoVeterinario.getListaAnimais().size());
    }

    @Test
    public void testeAltaAnimalNaoInternado() {
    	
    	// Cadastra Totó
        servicoVeterinario.cadastrarAnimal(animal1);
        
        // Verifica se Totó não está internado
        Assert.assertFalse(animal1.isInternado());

        // Dá alta mesmo se o Totó não está internado
        servicoVeterinario.darAlta("Totó");

        // Verifica se Totó ainda não está internado
        Assert.assertFalse(animal1.isInternado());
    }
}
