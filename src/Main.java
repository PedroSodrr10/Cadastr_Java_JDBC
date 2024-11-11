import com.curso.dao.ClienteDAO;
import com.curso.dao.DAOFactory;
import com.curso.modelo.Cliente;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        String nome = JOptionPane.showInputDialog(null, "Nome do cliente",
                JOptionPane.QUESTION_MESSAGE);
        String dataNascimento = JOptionPane.showInputDialog(null, "Data de nascimento",
                JOptionPane.QUESTION_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "E-mail",
                JOptionPane.QUESTION_MESSAGE);
        String telefone = JOptionPane.showInputDialog(null, "Telefone",
                JOptionPane.QUESTION_MESSAGE);
        String cpf = JOptionPane.showInputDialog(null, "CPF",
                JOptionPane.QUESTION_MESSAGE);

        cliente.setNome(nome);
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc = formato.parse(dataNascimento);
            cliente.setDataNascimento(dataNasc);
        } catch(Exception _){}

        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);

        ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
        clienteDAO.salvar(cliente);

        System.out.println("Cliente salvo com sucesso!");
    }
}