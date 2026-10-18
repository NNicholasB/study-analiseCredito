package com.nbgraciano.analisecredito.service;

import com.nbgraciano.analisecredito.domain.Proposta;
import com.nbgraciano.analisecredito.exception.StrategyException;
import com.nbgraciano.analisecredito.service.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnaliseCreditoService {

    @Autowired
    private NotificacaoRabbitMQService service;

    @Autowired
    private List<CalculoPonto> calculoPontoList;

    @Value("${rabbitmq.propostaconcluida.exchange}")
    private String exchangePropostaConcluida;

    public void analisar(Proposta proposta){
       try{
           int pontos=calculoPontoList.stream().mapToInt(impl-> impl.calcular(proposta)).sum();
           proposta.setAprovada(pontos> 350);
       } catch (StrategyException e) {
        proposta.setAprovada(false);
        proposta.setObservacao(e.getMessage());
       }
       service.notificar(exchangePropostaConcluida,proposta);
    }
}
