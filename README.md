# Bejeweled
Bejeweled is a cli based puzzle game. The game consists of a grid (of any size, e.g. 10x10) of “jewels”. Some example jewels are Diamond (D), Square (S), Triangle (T) and Wildcard (W). The goal is to find three jewels that are match in a row, column or diagonal by selecting the right coordinate. When this occurs, the three jewels are deleted, and other jewels fall from the top to fill in gaps. If the selected coordinate does not have any triple to match, then a warning message is displayed to the user and a new coordinate is requested.
Each jewel match in a different way. For the shape types defined as above, Diamond can match with other Diamonds only in diagonal coordinates. Square can match with its kind only in horizontal coordinate (x-axis). Triangle can match with its kind only in vertical coordinate (y-axis). Wildcard can match any jewel in any direction. Each jewel in a triple is worth a predetermined number of points. Diamond, Square, Triangle and Wildcard are scored as 30, 15, 15, 10 points respectively. So, a triple of all Diamonds will get 90 points, but a triple of 2 Diamonds and a Wildcard will be 70 points.
The coordinate specified by user can be either first or last item in triple.


For details about the implementation see the Info.pdf
