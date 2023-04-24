/**
 * joinform 검증
 */

$("#memberID").blur(idCheck);

function idCheck(){
	$.ajax({
		type:"GET",
		url:"./idDuplicateCheck",
		data:{
			userName:$('#memberID').val()
		},
		success:function(data){
			if(data == false){
				console.log("중복아님")
			}else{
				console.log("중복")
			}
		},
		error:function(){
			console.log("오류");
		}
	})
}

$('#join').on('click', function(){
	$.ajax({
		type:"POST",
		url:"./join",
		data:{
			userName:$('#memberID').val(),
			password:$('#memberPw1').val(),
			name:$('#name').val(),
			email:$('#email').val(),
			birth:$('#birth').val(),
			enabled:1
		}
	})
})