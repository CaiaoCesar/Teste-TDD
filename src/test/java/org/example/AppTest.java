package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Descrição:
 *
 * @author CaioCesar
 **/
class AppTest {
    //Com lambda
    @Test
    @DisplayName("Casos de Teste para Numero de Nucleotideos")
    public void testLambdaApp() {
        assertAll(
                () -> assertEquals("Erro pois o caractere informado é inválido", App.calculaNucletideos(B)),
                () -> assertEquals("O valor retornado é null pois os caracteres invalidos ultrapassou 10%", App.calculaNucletideos())
        );
    }
}