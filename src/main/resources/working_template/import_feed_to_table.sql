exec add_channel @channel_name='Rich Dad Education'
exec add_category @cat_name = 'Real Estate', @channel_id=11, @file_name='richdad_realestate.xml'


select * from feed_channel
select * from feed_category


	DECLARE @sqlStmt nvarchar(max)

	DECLARE @x xml
	DECLARE @hdoc int
	DECLARE @minutesDiff int
	DECLARE @temp_pubDate varchar(max)
	DECLARE @temp_title varchar(max)
	DECLARE @timeConverted datetime
	DECLARE @timeLastFeed datetime
	DECLARE @titleLastFeed varchar(max)

	SELECT @x=P FROM OPENROWSET (BULK 'F:\vincentko_dev\git\SpringApp\feedAggregate\src\main\resources\feed_xml\file\aol_realestate.xml', SINGLE_BLOB) AS Feeds(P)
	SELECT @x

		;WITH XMLNAMESPACES('http://purl.org/dc/elements/1.1/' AS dc)
		insert into feed_temp (title,guid,link,description,pubDate)
		SELECT 
			x.value('title[1]','VARCHAR(MAX)') AS title,
			x.value('guid[1]','VARCHAR(MAX)') AS guid,
			x.value('link[1]','VARCHAR(MAX)') AS link,
			x.value('description[1]','VARCHAR(MAX)') AS description,
			x.value('dc:date[1]','VARCHAR(MAX)') AS date
		FROM @x.nodes('/rss/channel/item') d(x)
		truncate table feed
		select * from feed_temp

		select CAST(CONVERT(datetimeoffset, '2013-09-06T10:08:00+00:00', 127) as datetime)