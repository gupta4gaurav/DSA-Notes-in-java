
        // Vertical Up
        for(int i = row - 1; i >= 0; i--){
            if(board[i][column] == 'Q'){
                return false;
            }
        }
        // Diagonal Left Up
        for(int i = row - 1, j = column - 1 ; i >= 0 && j>= 0; i--, j--){
            if(board[i][column] == 'Q'){
                return false;
            }
        }
        // Diagonal Right Up
        for(int i = row + 1, j = column + 1 ; i >= 0 && j>= 0; i--, j++){
            if(board[i][column] == 'Q'){
                return false;
            }
        }
        return true;
    