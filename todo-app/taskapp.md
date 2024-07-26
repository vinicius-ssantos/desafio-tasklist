# To-Do App

Este projeto é um aplicativo de lista de tarefas desenvolvido com React e Create React App. Ele permite que os usuários criem, editem e excluam tarefas, além de marcar tarefas como concluídas.

## Tecnologias Utilizadas

- **JavaScript**
- **React**
- **Axios**
- **React Icons**
- **Jest** (para testes)



## Scripts Disponíveis

No diretório do projeto, você pode executar:

### `npm start`

Executa o aplicativo no modo de desenvolvimento.\
Abra [http://localhost:3000](http://localhost:3000) para visualizá-lo no navegador.

A página será recarregada quando você fizer alterações.\
Você também verá quaisquer erros de lint no console.

### `npm test`

Inicia o executor de testes no modo interativo de observação.\
Veja a seção sobre [executar testes](https://facebook.github.io/create-react-app/docs/running-tests) para mais informações.

### `npm run build`

Compila o aplicativo para produção na pasta `build`.\
Ele agrupa corretamente o React no modo de produção e otimiza a compilação para o melhor desempenho.

A compilação é minificada e os nomes dos arquivos incluem os hashes.\
Seu aplicativo está pronto para ser implantado!

Veja a seção sobre [implantação](https://facebook.github.io/create-react-app/docs/deployment) para mais informações.

### `npm run eject`

**Nota: esta é uma operação sem retorno. Uma vez que você `eject`, você não pode voltar!**

Se você não estiver satisfeito com a ferramenta de compilação e as escolhas de configuração, você pode `eject` a qualquer momento. Este comando removerá a dependência única de compilação do seu projeto.

Em vez disso, ele copiará todos os arquivos de configuração e as dependências transitivas (webpack, Babel, ESLint, etc) diretamente para o seu projeto para que você tenha controle total sobre eles. Todos os comandos, exceto `eject`, ainda funcionarão, mas eles apontarão para os scripts copiados para que você possa ajustá-los. Neste ponto, você está por conta própria.

Você nunca precisa usar `eject`. O conjunto de recursos curado é adequado para pequenas e médias implantações, e você não deve se sentir obrigado a usar este recurso. No entanto, entendemos que esta ferramenta não seria útil se você não pudesse personalizá-la quando estivesse pronto para isso.

## Estrutura do Projeto

- `src/`: Contém o código-fonte do aplicativo.
    - `components/`: Componentes React reutilizáveis.
    - `services/`: Serviços para comunicação com APIs.
        - `apiservice.js`: Serviço para fazer requisições HTTP usando Axios.
    - `setupTests.js`: Configuração para testes com Jest.
- `public/`: Contém arquivos estáticos públicos.
- `package.json`: Gerencia dependências e scripts do projeto.

## Configuração do Ambiente

1. Clone o repositório:
   ```sh
   git clone <URL_DO_REPOSITORIO>
   cd to-do-app