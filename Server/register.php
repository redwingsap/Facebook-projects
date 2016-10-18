<?php
$con = mysqli_connect('13.76.209.146','root','baabteadmin123!','Arjun_facebook');

if(isset($_REQUEST['firstname'])&&isset($_REQUEST['secondname'])&&isset($_REQUEST['email'])
&&isset($_REQUEST['gender'])&&isset($_REQUEST['bday'])&&isset($_REQUEST['bmonth'])&&isset($_REQUEST['byear'])&&isset($_REQUEST['password']))

	{     
	 $firstname=$_REQUEST['firstname'];
	 $secondname=$_REQUEST['secondname'];
	 $user_email=$_REQUEST['email'];
	 $gender=$_REQUEST['gender'];
	 $bday=$_REQUEST['bday'];
	 $bmonth=$_REQUEST['bmonth'];
	 $byear=$_REQUEST['byear'];
	 $user_password=$_REQUEST['password'];
		

	$insert_query="insert into Fb_registration(fname,sname,email,gender,dod,dom,doy,password)values('$firstname','$secondname','$user_email','$gender',$bday,$bmonth,$byear,'$user_password')";

	$result=mysqli_query($con,$insert_query);

	print_r($result);


	
	if($result){

			

			echo "Success";
			$Success = array('ResponseCode' =>'200','Msg'=>'Success');
			$Successdata=json_encode($Success);
			echo $Successdata;
			}

		else{
			$fail = array('ResponseCode' =>'500','Msg'=>'Registration Failed' );
			$faildata=json_encode($fail);
			echo $faildata;

		}
	
mysqli_close($con);

}

else{ 
	$data = array('ResponseCode' =>'500','Msg'=>'Fields are not defined');
		$js=json_encode($data);
		echo $js;
		
		}

?>