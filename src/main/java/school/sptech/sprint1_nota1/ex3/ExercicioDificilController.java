package school.sptech.sprint1_nota1.ex3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExercicioDificilController {

    @GetMapping("/ex-03/{n}")
    public ExercicioDificilResponse exercicioDificil(@PathVariable int n) {
        ExercicioDificilResponse resposta = new ExercicioDificilResponse();

        if (n <= 0){
            resposta.setEnesimoTermo(0);
            resposta.setSoma(0);
            return resposta;
        }

        int anterior = 0;
        int atual = 1;
        int soma = anterior + atual;

        if (n == 1) {
            resposta.setEnesimoTermo(1);
            resposta.setSoma(1);
            return resposta;
        }


        for (int i = 2; i <= n; i++) {
            int proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
            soma += atual;
        }

        resposta.setEnesimoTermo(atual);
        resposta.setSoma(soma);

        return resposta;
    }
}

