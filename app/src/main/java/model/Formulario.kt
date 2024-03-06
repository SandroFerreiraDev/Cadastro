package model

class Formulario(
    var nomeCompleto: String,
    var telefone: String,
    var email: String,
    var salvarEmail: Boolean,
    var sexo: String,
    var cidade: String,
    var uf: String
) {
    override fun toString(): String {
        return "Nome: $nomeCompleto, Telefone: $telefone, Email: $email, " +
                "Salvar Email: $salvarEmail, Sexo: $sexo, Cidade: $cidade, UF: $uf"
    }
}
