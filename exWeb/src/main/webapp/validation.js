/**
 * 
 */
function checkVal(form){
    let cnt=0;
    for(let i=0;i<form.choice.length;i++){
        if(form.choice[i].checked){
            cnt++;
        }
    }  
    if(cnt === 0){
        alert("최소한개 이상 체크 하세요");
    }  
    else{
        form.submit();
    }
}