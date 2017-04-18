<h1>Chess Pieces Problem
<a href="https://www.codefactor.io/repository/github/alexbolot/problemedesdames"><img src="https://www.codefactor.io/repository/github/alexbolot/problemedesdames/badge" /></a>
</h1>
<h2>Summary :</h2>
<ol>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames#1---about-the-project ">About the project</a><br />
<ol>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames#11---the-goal ">The goal</a></li>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames#12---how-to-use ">How to use</a></li>
</ol>
</li>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames#2---what-to-know-about-the-classes ">What to know about the classes</a><br />
<ol>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames#21---chessboard ">ChessBoard</a></li>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames#22---chesspiece ">ChessPiece</a>
<ol>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames#221---the-chess-pieces ">The Chess Pieces</a></li>
</ol>
</li>
</ol>
</li>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames/#3---coming-soon ">Coming soon</a></li>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames/#4---libraries ">Libraries</a></li>
<li><a href="https://github.com/AlexBolot/ProblemeDesDames/#5---author ">Author</a></li>
</ol>
<h2>1 - About the project</h2>
<p>This project is a study project, answering to a school assignment.</p>
<h3>1.1 - The goal</h3>
<p>"What's the maximum of Queens that I can place on a 8x8 Chess Board without them being in conflict" ?<br />This Project is here to answer this question !<br />But not only :</p>
<ul>
<li>It will give you the answer to any official Chess Piece</li>
<li>It will also give you the answer on a nxm grid (you specify the m &amp; n &mdash;&gt; m &amp; n &lt; 10.000)
<ul>
<li>Note : the max n value should be tested in the next version.</li>
</ul>
</li>
</ul>
<h3>1.2 - How to use</h3>
<p>The App class starts the Application. It has a small CLI that asks you for the main informations :</p>
<ul>
<li>Width of your grid</li>
<li>Height of your grid</li>
<li>The Chess Piece you want to use</li>
<li>How many attempts (note that the more attemps you select, the more accurate your result will be)</li>
</ul>
<p>It will the solve the problem and print 3 informations :</p>
<ul>
<li>The max number of ChessPieces placed on the grid</li>
<li>The time spend for the calculation in miliseconds</li>
<li>The grid with the most optimal combination found during the process</li>
</ul>
<h2>2 - What to know about the classes</h2>
<h3>2.1 - ChessBoard</h3>
<p>The ChessBoard&nbsp;class has 3 main tasks :</p>
<ul>
<li>Handling the grid (setting and getting the value of each position)</li>
<li>Asking the ChessPiece to apply it's pattern on the grid</li>
<li>Printing the grid when it's the optimal grid found.</li>
</ul>
<p>Note : this class implements IChessBoard, an Interface that imposes the methods needed by the ChessPiece to apply its pattern.</p>
<pre>public interface IChessBoard<br />{<br /> int getStatus (int row, int col);<br /> <br /> void setStatus (int row, int col, int status);<br />}</pre>
<h3>2.2 - ChessPiece</h3>
<p>The ChessPiece interface&nbsp;imposes the methods needed by the ChessPiece to apply its pattern.</p>
<pre>public abstract class ChessPiece<br />{<br /> public abstract void applyPattern (Object sender, int row, int col);<br />}</pre>
<h4>2.2.1 - The Chess Pieces</h4>
<p>Here is the list of all the Chess Pieces implemented in this application :</p>
<p><img src="http://d2r5da613aq50s.cloudfront.net/wp-content/uploads/281902.image0.jpg" alt="ChessPiecePatterns" width="535" height="386" /></p>
<p>Note : The Chess Pieces all extends the ChessPiece class. This way they all behave the same way.</p>
<h2>3 - Coming soon</h2>
<p>Please check the TODO.md file in this repository to find out what updates are planned.</p>
<h2>4 - Libraries</h2>
<p>Only 3 libraries are used for this Maven QuickStart project</p>
<ul>
<li>Java8 : JDK 1.8.111</li>
<li>Maven : JUnit 4.12</li>
<li>Maven : hamcrest-core:1.3</li>
</ul>
<p>Note : those libraries are already included in : org.jetbrains.idea.maven.model.MavenArchetype@88f75e0f</p>
<h2>5 - Author</h2>
<p>Alexandre BOLOT<br />My <a href="https://github.com/AlexBolot">GitHub</a><br />My <a href="https://www.linkedin.com/in/alexandrebolot">LinkedIn</a></p>
