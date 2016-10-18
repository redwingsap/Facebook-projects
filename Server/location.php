<?php
$con = mysqli_connect('13.76.209.146','root','baabteadmin123!','Arjun_facebook');

if(isset($_REQUEST['stat']))
	{


$loc_stat = $_REQUEST['stat'];


$insert_query = "insert into location (status)values('$loc_stat')";

$result=mysqli_query($con,$insert_query);


	if($result){

			echo "Success";
			$Success = array('ResponseCode' =>'200','Msg'=>'Success');
			$Successdata=json_encode($Success);
			echo $Successdata;
			}

		else{
			$fail = array('ResponseCode' =>'500','Msg'=>'location insertion Failed' );
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