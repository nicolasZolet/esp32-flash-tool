# Gravador ESP-32
Para gravar um arquivo binário gerado pela Arduino IDE no ESP-32 seguir as seguintes instruções:

## Instruções:

**1.0:** No **Arduino IDE** selecionar a opção "Sketch" -> "Export Compiled Binary"

**2.0:** Depois de compilado, acessar a pasta onde os arquivos foram gerados apresentada no terminal do Arduino IDE. Exemplo: "C:\User\AppData\Local\Temp\sketch\"

**3.0:** Copiar os 2 arquivos binarios (.bin) que estão na pasta gerada pelo Arduino IDE e colar na pasta que você esta lendo este arquivo (README.md)

**4.0** Alterar o nome do arquivo binário compilado para **program.bin**
**4.1** Alterar o nome do arquivo binário contendo as partições para **partitions.bin**
**4.2** Se necessário, alterar a porta COM no arquivo **FLASH.cmd**

**5.0** Executar o arquivo **FLASH.cmd**

## Desenvolvido por:
Nicolas Zolet em 21/12/2023
