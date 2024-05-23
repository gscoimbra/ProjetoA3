package Entidades;

public class Cliente extends Pessoa {

        private static int contador = 1;
        private int idCliente;
        private double carteira;
        private String email;
        private String telefone;

        public Cliente(String nome, int idade, String sexo, String cpf, String endereco, double carteira, String email,
                        String telefone) {
                super(nome, idade, sexo, cpf, endereco);
                this.idCliente = contador;
                this.carteira = carteira;
                this.email = email;
                this.telefone = telefone;
                Cliente.contador++;
        }

        public double getCarteira() {
                return carteira;
        }

        public void setCarteira(double carteira) {
                this.carteira = carteira;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getTelefone() {
                return telefone;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }

        public int getIdCliente() {
                return idCliente;
        }

}
