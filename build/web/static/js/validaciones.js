/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarNum(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
    if(code==8 || code==11){
        return true;
    }else if(code>=48 && code<=57){
        return true;
    }else{
        return false;
    }
}

