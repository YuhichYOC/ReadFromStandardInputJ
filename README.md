Paiza 攻略用 -- 標準入力を拾うためのサンプル集です。  
参考情報のページに載っている情報が貧弱ゥなので多少盛りました。  
標準入力の扱い慣れでプレイヤーごとに差がでるのもアホらしいし。  
これくらいのチートはええやろ ( 適当 )  
  
------- 仕様 -------  
サンプルコードは Test01, Test02 および Test03 の 3 種類存在します。  
それぞれ  
Test01  
入力 : 1 行 & 1 アイテム  
出力 : String  
Test02  
入力 : 1 行 & 複数アイテム  
出力 : String  
Test03  
入力 1 : 複数行 & 複数アイテム  
入力 2 : 最初の行の最初のアイテムは入力行数  
出力 : List&lt;String&gt;  
Test04  
入力 1 : 複数行 & 複数アイテム  
入力 2 : 最初の行の最初のアイテムは入力行数  
出力 : List&lt;List&lt;String&gt;&gt;  
  
ReadFromStandardInput と同じく拾った結果はどこにも返さずそのまま標準出力へ表示させています。  
各位ご利用の際は String や List&lt;String&gt; で結果を返させるよう変更を行ってください。  
また、C++ 版とは異なり入力行のトークン分割を行っていません。  
  
Test01 と Test02 について  
これら 2 つのサンプルは結果としてまるで同じコードになりました。  
C++ 版と比較をしてみたかったのであえて残しています。  
  
Test03, Test04 について  
行数の扱いは「行数 & 列数の定義が記載されている最初の行」を含みません。  
列数についても考慮せず、入力のあったすべてのデータを List に保持しています。  
コメントにある通り、入力行数の最大行は 10 行までに制限しています。  
また、入力チェックを正規表現で行っているので制限の解除をするときは ret &gt; 10 以外に正規表現も桁数の修正が必要です。  
