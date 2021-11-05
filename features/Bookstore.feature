Feature:  Bookstore Automate

Scenario Outline:Order Book And covers
	Given BookStore Url Open
	When Validate Url
	Then Order One Hindi Book "<hindibook>","<hindiAuthor>","<HLang>","<Hquant>"
	Then Order Book drop down "<ComboBookName>","<Ctype>","<ComboAuthor>","<CLang>","<Cquant>"
	Then Search Book And order it "<SBName>","<Squant>"
	Then Order one Backcover "<Brandname>","<Model>","<Bquant>"
	
	
	
Examples:
	|hindibook |hindiAuthor|HLang  |Hquant|ComboBookName                                                                 |Ctype      |ComboAuthor|CLang    |Cquant  |SBName       |Squant|Brandname|Model    |Bquant|
	|KARMABHUMI|Premchand  |English|3     |The Lost Symbol, Inferno & Origin (Set of 3 Dan Brown Combo Hardcover Edition)|Books Combo|Dan Brown  |English  |2       |Wings of Fire|4     |Apple    |iPhone 11|2     |