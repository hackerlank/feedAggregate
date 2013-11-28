 <script type="text/javascript" charset=UTF-8">
	$().ready(function() {

		$("a.slide-toggle-link").click(function(){
			$("table#mytable").hide();
					
			var element = parseInt($(this).attr("name").substring(15));
			$("table#mytable[name='slide-table-inventory"+element+"']").slideToggle('slow');
		}); 

	});

</script>