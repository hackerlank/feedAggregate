 <script type="text/javascript" charset=UTF-8">
	$().ready(function() {

   		$("a.show").click(function(){ 	   		
   			var element = $(this).attr("id");
   			$(".vocab_shuffle_back").hide();
   			$("#back"+element.substring(4)+".vocab_shuffle_back").show();   		
   		}); 
   				
   		$("a.shuffle").click(function(){ 	
   	   		 		
   			var element = parseInt($(this).attr("id").substring(7)) + 1;
   			$(".vocab_shuffle_back").hide();
   			$(".vocab_shuffle_front").hide();
   			$("#front"+element+".vocab_shuffle_front").show();   		
   		}); 
	
		$(".vocab_shuffle_front").hide();   
		$(".vocab_shuffle_back").hide();
	    $("#front1.vocab_shuffle_front").show();

	});

</script>