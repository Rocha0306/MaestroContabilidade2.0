package com.example.MaestroContabilidade;

import Model.BancoDeDados.IdentificarUsuarioBD;
import Model.BancoDeDados.LoginBD;
import jakarta.servlet.http.PushBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@RequiredArgsConstructor
@Controller
public class ControllerDeAcessoUsuario {


    public String UsuarioLogado;

    public boolean UsuarioFezLogin;

    public String Nivel;



    @RequestMapping("/login")
    public String Login(@RequestParam String CPF, @RequestParam String Password, Model model) throws SQLException {


        try {
            IdentificarUsuarioBD NivelDeAcesso = new IdentificarUsuarioBD();
            Nivel = NivelDeAcesso.IdentificarUsuarioBD(CPF);
            model.addAttribute("NivelDeAcesso", Nivel);
            if (CPF != null && Password != null) {
                LoginBD Login = new LoginBD();
                Login.Login(CPF, Password);
                if(Login.isUsuarioTemCadastroCPF() == true && Login.isUsuarioTemCadastroSenha() == true) {
                    UsuarioFezLogin = true;
                    return "HomePage";

                }

                else {
                    return "InfoIncorreta";
                }
            }

            else {
                return "InfoIncorreta";
            }

        }

        catch (SQLException e) {
            return "InfoIncorreta";
        }




    }


    @GetMapping("/Diario")
    public String Diario(){


        if(UsuarioFezLogin == true) {
            return "Diario";
        }

        else {
            return "Index";
        }

    }

    @GetMapping("/Fatos")
    public String Fatos() {
        if(UsuarioFezLogin == true) {
            return "Fatos";
        }

        else {
            return "Index";
        }

    }

    @GetMapping("/Razonete")
    public String Razonete() {
        if(UsuarioFezLogin == true) {
            return "Razonete";
        }

        else {
            return "Index";
        }


    }

    @GetMapping("/Balancete")
    public String Balancete() {
        if(UsuarioFezLogin == true) {
            return "Balancete";
        }

        else {
            return "Index";
        }

    }

    @GetMapping("/DeletarFato")
    public String DeletarFato() {
        if(UsuarioFezLogin == true) {
            return "DeletarFato";
        }

        else {
            return "Index";
        }

    }




    @GetMapping("")
    public String Restart() {
       UsuarioFezLogin = false;
       return "Index";
    }


    @GetMapping("/Codigos")
    public String Codigos() {
        if(UsuarioFezLogin == true) {
            return "Codigos";
        }

        else {
            return "Index";
        }
    }

    @GetMapping("/ARE")
    public String ARE() {
        if(UsuarioFezLogin == true) {
            return "ARE";
        }

        else {
            return "ARE";
        }
    }





}
