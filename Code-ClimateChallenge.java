/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/
    //encontra o menor valor na arvore
    //(o no folha mais a esquerda)
    int min(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }

    //encontra o maior valor na arvore
    //(o no folha mais a direita)
    int max(Node root){
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }

    boolean checkBST_Aux(Node root, int min, int max){
        //se o no for null, ja passamos do fim da arvore
        if(root == null) return true;
        
        //se o valor do no nao estiver entre o minimo e o maximo
        //que pode ser assumido ali, nao eh BST
        else if(root.data < min || root.data > max) return false;

        //dos nos folhas ate a raiz, verificamos recursivamente
        //se os valores dos nos sao adequados.
        //localmente, o filho a direta tem que ser maior e o a esquerda
        //menor que o no raiz da subarvore. Globalmente, todos a esquerda tem que
        //ser menor que a raiz, e os a direita maior. Ou seja, mesmo o maior
        //valor a esquerda tem que ser menor que a "raiz global", e o menor
        //a direita maior que a "raiz global"
        return ( checkBST_Aux(root.left, min, (root.data - 1))
                && checkBST_Aux(root.right, (root.data + 1), max));
    }

    //executa checkBST_AUX e devolve se eh ou nao BST
    boolean checkBST(Node root) {
        return(checkBST_Aux(root, min(root), max(root)));
    }