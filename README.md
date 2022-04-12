# Flights Informations

Arquivo de entrada:

origin;destination;airline;departure;arrival;price

MEL-Austrália;GRU-Brasil;Gol Airlines;21/04/2022 06:00:00 (+01:00);22/04/2022 02:00:00 (+04:00);3758.00 KIN-Jamaica;PEK-China;Lufthansa;10/04/2022 12:00:00 (+10:00);10/04/2022 04:00:00 (-02:00);4842.00

Objetivos: Calcular tempo de voo em horas de cada voo Agrupar voos por origem/destino e ordená-los por tempo de voo (crescente), preco (crescente), nome da companhia (crescente) Criar 2 arquivos de saída:

1 contendo toda a relação de voos mantendo as colunas originais e incluindo uma nova coluna contendo o tempo do voo (manter ordenação acima)
1 contendo um resumo de informações:
voo mais rapido por origem/destino
voo mais longo por origem/destino
voo mais barato por origem/destino
tempo médio de voo origem/destino
preço médio por origem/destino
Detalhes:

A Data/Hora estão com o fuso horário, de acordo com o seguinte formato: dia/mes/ano hora:minuto:segundo (fuso horário). Ex.: 13/03/2022 10:15:30 (-03:00)
Price: em reais (R$)
Utilizar a API Java Time
Utilizar a API IO ou NIO ou NIO2 para leitura e escrita de arquivos
Utilizar mandatoriamente Streams/Lambdas para realizar operações sobre os elementos do arquivo: desde agrupamentos, cálculo de tempo de voo até o cálculo das informações do resumo
Arquivos de entrada e saída no formato ".csv", charSet UTF-8
Caracter separador de colunas: ";"
Cabeçalhos dos arquivos gerados:

1º arquivo: origin;destination;airline;departure;arrival;price;time

2º arquivo: origin;destination;shortest_flight(h);longest_fight(h);cheapest_flight;most_expensive_flight;average_time;average_price
