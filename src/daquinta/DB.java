

package daquinta;


import java.awt.Font;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class DB
{
    private String tmp;//guarda o nome do login temporario
    private static DB novo;
    private ArrayList<String> s = new ArrayList<String>();
    private String String;
    
    //data
    
    Font displayFont = new Font("Serif", Font.BOLD, 18);  
   
    //String result = s.substring(0, 26) + ":" + s.substring(27);   0000-00-00 00:00:00

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = new java.util.Date();
    
    DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
    Calendar cal = Calendar.getInstance();
    Calendar calUk = Calendar.getInstance(Locale.UK);  
    
    Integer ano = date.getYear()+1900;
             
    static Connection connection = null;
    ResultSet rs=null;;
    Statement st=null;
    PreparedStatement pst=null;

    Integer  getWeekofYear = calUk.get( Calendar.WEEK_OF_YEAR );
    
    static String url ="jdbc:mysql://localhost:3306/";
    static String dbName = "daquinta_teste"; //Nome do Banco criado
    static String userName = "root"; //Usuário do banco
    static String passWord = "admin"; //Senha de conexão
    
    private static Connection createDBConnection() {
        try {
            
           
           Class.forName("com.mysql.jdbc.Driver");
          
           connection = DriverManager.getConnection(url+dbName,userName,passWord);
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
    System.out.println("Conectado!");
        return connection;
    }

    private void actualizarDB(String query) throws Exception {
        connection = DB.createDBConnection();
        st = connection.createStatement();
        st.execute(query);
        st.close();
    }

    private ResultSet executeQuery(String query) throws Exception {
        connection = DB.createDBConnection();
        st = connection.createStatement();
        rs = st.executeQuery(query);
        return rs;
    }

    public int validaLogin(String a, String b) {
        try {
            //int tt = 1;
            rs = executeQuery("SELECT * FROM "+dbName+".users");
            String tipo;
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                tipo = rs.getString("tipo");
                if (username.equals(a)&& password.equals(b)) {
                    rs.close();
                    connection.close();
                    //System.out.println(tipo);
                        
                    //return tt;
                    return Integer.parseInt(tipo);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void inserirRestauranteNovo(String nome, String morada, int telefone, int nif, String gps, String historico, int totalidade, int localizacao) {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            
            ResultSet rss = stmt2.executeQuery("SELECT * FROM "+dbName+".restaurantes") ;
            
            int x=0;
            int y=0;
            rss.last();
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
           
            stmt.executeUpdate("INSERT INTO "+dbName+".restaurantes  VALUES ('"+x+"','" + nome + "', '" + 
                    morada + "', '" + telefone + "', '" + nif + "', '" + gps + "', '" + historico + "', "
                    + "'"+totalidade+"', '"+localizacao+"')");
    
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void inserirRestauranteEditar(int id, String nome, String morada, int telefone, int nif, String gps, String historico, int totalidade, int localizacao) {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            
            ResultSet rss = stmt2.executeQuery("SELECT * FROM "+dbName+".restaurantes") ;
            
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET nome='"+nome+"' WHERE idrestaurantes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET morada='"+morada+"' WHERE idrestaurantes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET telefone='"+telefone+"' WHERE idrestaurantes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET nif='"+nif+"' WHERE idrestaurantes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET gps='"+gps+"' WHERE idrestaurantes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET notas='"+historico+"' WHERE idrestaurantes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET totalidadeEncomenda='"+totalidade+"' WHERE idrestaurantes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".restaurantes  SET localizacao='"+localizacao+"' WHERE idrestaurantes=" + id +";");
            
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void inserirTransporteNovo(String matricula, int carga, int tipo, String notas) {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            
            ResultSet rss = stmt2.executeQuery("SELECT * FROM "+dbName+".transportes") ;
            
            int x=0;
            int y=0;
            rss.last();
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
           
            stmt.executeUpdate("INSERT INTO "+dbName+".transportes  VALUES ('"+x+"','" + matricula + "', '" + carga + "', '" + tipo + "', '" + notas +  "')");
    
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
                                            
    public void inserirTransporteEditar(int id, String matricula, int carga, int caixas, String notas) {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            
            ResultSet rss = stmt2.executeQuery("SELECT * FROM transportes") ;
            
            stmt.executeUpdate("UPDATE "+dbName+".transportes  SET matricula='"+matricula+"' WHERE idtransportes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".transportes  SET qtdcarga='"+carga+"' WHERE idtransportes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".transportes  SET qtdcaixas='"+caixas+"' WHERE idtransportes=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".transportes  SET notas='"+notas+"' WHERE idtransportes=" + id +";");
            
    
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void inserirProdutoNovo(String nome, int tipo, String notas, int jan, int fev, int mar, int abr, int mai, int jun, int jul, int ago, int set, int out, int nov, int dez, int mesesarmazenamento) {
        try {
            
            connection = DB.createDBConnection();
            Statement sNewClasstmt=null;
            Statement stmt=null;
            stmt = connection.createStatement();
                       
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".produtos") ;
            
            int x=0;
            int y=0;
            rss.last();
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
           
            stmt.executeUpdate("INSERT INTO "+dbName+".produtos  VALUES ('"+x+"','" + nome + "', '" + tipo + "', '" + notas +  "', '"+jan
                    +"', '"+fev+"', '"+mar+"', '"+abr+"', '"+mai+"', '"+jun+"', '"+jul+"', '"+ago+"', '"+set+"', '"+out+
                    "', '"+nov+"', '"+dez+"', '" + mesesarmazenamento + "')");
    
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
                                            
    public void inserirProdutoEditar(int id, String nome, int tipo, String notas, int jan, int fev, int mar, int abr, int mai, int jun, int jul, int ago, int set, int out, int nov, int dez, int mesesarmazenamento) {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            stmt = connection.createStatement();
           
            ResultSet rss = stmt.executeQuery("SELECT * FROM produtos") ;
            
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET nome='"+nome+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET tipo='"+tipo+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET nota='"+notas+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET jan='"+jan+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET fev='"+fev+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET mar='"+mar+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET abr='"+abr+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET mai='"+mai+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET jun='"+jun+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET jul='"+jul+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET ago='"+ago+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET sete='"+set+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET outu='"+out+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET nov='"+nov+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET dez='"+dez+"' WHERE idprodutos=" + id);
            stmt.executeUpdate("UPDATE "+dbName+".produtos  SET mesesarmazenamento='"+mesesarmazenamento+"' WHERE idprodutos=" + id);
            
    
            stmt.close();
            
            rss.close();
            connection.close();
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void inserirFornecedorNovo(String nome, String morada, int telefone, int nif, String gps, String historico) {
        try {
            System.out.println("inserirFornecedorNovo");
            connection = DB.createDBConnection();
            Statement stmt=null;
            stmt = connection.createStatement();
            
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".produtores") ;
            
            int x=0;
            int y=0;
            rss.last();
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
           
            stmt.executeUpdate("INSERT INTO "+dbName+".produtores  VALUES ('"+x+"','" + nome + "', '" + morada + "', '" + telefone + "', '" + nif + "', '" + gps + "', '" + historico + "')");
            
            stmt.close();
            rss.close();
            connection.close();
            
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void inserirFornecedorEditar(int id, String nome, String morada, int telefone, int nif, String gps, String historico) {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            
            ResultSet rss = stmt2.executeQuery("SELECT * FROM "+dbName+".produtores") ;
            
            stmt.executeUpdate("UPDATE "+dbName+".produtores  SET nome='"+nome+"' WHERE idfornecedores=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".produtores  SET morada='"+morada+"' WHERE idfornecedores=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".produtores  SET telefone='"+telefone+"' WHERE idfornecedores=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".produtores  SET nif='"+nif+"' WHERE idfornecedores=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".produtores  SET gps='"+gps+"' WHERE idfornecedores=" + id +";");
            stmt.executeUpdate("UPDATE "+dbName+".produtores  SET notas='"+historico+"' WHERE idfornecedores=" + id +";");
    
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public int ConjuntoProdutos(int P) {
        int [] conjunto;
        try {
            connection = DB.createDBConnection();
            Statement stmt=null;
            stmt = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".produtos") ;
            rss.absolute(P+1);
            
            return rss.getInt("idprodutos");            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return -1;
    }
    
    public String ConjuntoProdutosNome(int P) {
       
        try {
            connection = DB.createDBConnection();
            Statement stmt=null;
            stmt = connection.createStatement();
            
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".produtos") ;
            
          
            rss.absolute(P+1);
            
             
            return rss.getString("nome");            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return "ERRO";
    }
    
    public String ConjuntoProdutosFrescoSecos(int P) {
       
        try {
            connection = DB.createDBConnection();
            Statement stmt=null;
            stmt = connection.createStatement();
            
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".produtos") ;
            
           
          
            rss.absolute(P+1);
            if (rss.getInt("tipo") == 1) return rss.getString("nome"); 
            if (rss.getInt("tipo") == 2) return rss.getString("nome");  
            return rss.getString("nome");            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return "ERRO";
    }
    
    public int NumCols() {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            stmt = connection.createStatement();
            
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".produtos") ;
            int i=0;
            while (rss.next()) i++;
            
            return i;
                   
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return -1;
    }
    
    public void AdicionarNovaPreEncomenda(int idRestaurante, String Produto, int quantidade, int mes)  {
          try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            stmt = connection.createStatement();
             stmt2 = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".pre_encomenda") ;
            ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");
            int x=0;
            int y=0;
            rss.last();
            rss2.next();
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
           
            stmt.executeUpdate("INSERT INTO "+dbName+".pre_encomenda  VALUES ('"+x+"','" + 
                    idRestaurante + "', '" + rss2.getInt("idprodutos") + "', '" + quantidade + 
                    "', '"+ ano + "', '" + mes + "')");
    
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
     public void RetirarPreEncomenda(int idRestaurante, String Produto, int quantidade, int mes)  {
          try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            Statement stmt3=null;
            stmt = connection.createStatement();
             stmt2 = connection.createStatement();
             stmt3 = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".pre_encomenda") ;
            ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");
            rss2.next();
            
           ResultSet rss3 = stmt3.executeQuery("SELECT * FROM "+dbName+".pre_encomenda WHERE "
                    + dbName+".pre_encomenda.mes="+mes+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                   " AND "+dbName+".pre_encomenda.restaurantes_idrestaurantes="+idRestaurante +";") ;
               
           rss3.next();
         
           if ((rss3.getInt("quantidade")-quantidade)<=0) {
                   // JOptionPane.showMessageDialog(frame,"Roseindia.net");
                 stmt.executeUpdate("UPDATE "+dbName+".pre_encomenda SET quantidade="+0
                    +" WHERE mes="+mes+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
           }
           else {
               stmt.executeUpdate("UPDATE "+dbName+".pre_encomenda SET quantidade="+(rss3.getInt("quantidade")-quantidade)
                    +" WHERE mes="+mes+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
           }
           stmt.close();
            rss.close();
            rss2.close();
            rss3.close();
            connection.close();
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
     
     public void AdicionarPreEncomenda(int idRestaurante, String Produto, int quantidade, int mes)  {
          try {
              
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            Statement stmt3=null;
            Statement stmt4=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            stmt3 = connection.createStatement();
            stmt4 = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".pre_encomenda") ;
            ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");    
            rss2.next();
             ResultSet rss4 = stmt4.executeQuery("SELECT SUM(mes) FROM "+dbName+".pre_encomenda "
                     + " WHERE mes="+mes+" AND ano="+ano
                     + " AND produtos_idprodutos="+rss2.getInt("produtos.idprodutos")+" AND restaurantes_idrestaurantes="+idRestaurante) ;
            
            
            rss4.next();
            rss.next();
            if (rss4.getInt("SUM(mes)")==0) {
                int x=0;
                int y=0;
                y=rss.getRow();
                if (y==0){
                    x=1;
                }else if (y != 0){
                    rss.last();
                    x=rss.getInt(1)+1;
                }
                //System.out.println("SUM " + x);
                stmt.executeUpdate("INSERT INTO "+dbName+".pre_encomenda VALUES ('"+x+"','" + 
                idRestaurante + "', '" + rss2.getInt("idprodutos") + "', '" + quantidade  + "', '" +
                ano + "', '" + mes + "')");
                
            }
            else{
             
                stmt.executeUpdate("UPDATE "+dbName+".pre_encomenda SET quantidade="+quantidade
                        + " WHERE mes="+mes+" AND produtos_idprodutos="+rss2.getInt("idprodutos")
                        + " AND restaurantes_idrestaurantes="+idRestaurante+" AND ano="+ano+";");
               
               
           }
           stmt.close();
            rss.close();
            rss2.close();
            
            rss4.close();
           
            connection.close();
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    public void AdicionarNovaEncomenda(int idRestaurante, String Produto, int qtdSeg, int qtdTer, int qtdQua, int qtdQui, int qtdSex)  {
            try {
            
                connection = DB.createDBConnection();
                Statement stmt=null;
                Statement stmt2=null;
                stmt = connection.createStatement();
                stmt2 = connection.createStatement();
                ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".encomenda") ;
                ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");
                int x=0;
                int y=0;
                rss.last();
                rss2.next();
                y=rss.getRow();
                if (y==0){
                    x=1;
                }else if (y != 0){
                    rss.last();
                    x=rss.getInt(1)+1;
                }

                stmt.executeUpdate("INSERT INTO "+dbName+".encomenda VALUES ('"+x+"','" + 
                idRestaurante + "', '" + rss2.getInt("idprodutos") + "', '" + dateFormat.format(date)  + "', '" +
                qtdSeg + "', '" + qtdTer + "', '" + qtdQua + "', '" + qtdQui + "', '" +
                qtdSex + "', '"+getWeekofYear+"')");

                    stmt.close();
                    //rs.close();
                    rss.close();
                    connection.close();
                    System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
       
    }
    public void RetirarEncomenda(int idRestaurante, String Produto, int qtdSeg, int qtdTer, int qtdQua, int qtdQui, int qtdSex)  {
          try {
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            Statement stmt3=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            stmt3 = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".encomenda") ;
            ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");
            rss2.next();
            
           ResultSet rss3 = stmt3.executeQuery("SELECT * FROM "+dbName+".encomenda WHERE "
                    + "encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                   " AND encomenda.restaurantes_idrestaurantes="+idRestaurante +";") ;
               
           rss3.next();
         
           /*if ((rss3.getInt("qtdseg")-qtdSeg)<=0 || (rss3.getInt("qtdter")-qtdTer)<=0 || (rss3.getInt("qtdqua")-qtdQua)<=0
                   || (rss3.getInt("qtdqui")-qtdQui)<=0|| (rss3.getInt("qtdsex")-qtdSex)<=0) {
                   // JOptionPane.showMessageDialog(frame,"Roseindia.net");
                 stmt.executeUpdate("UPDATE daquinta_teste.encomenda SET quantidade="+0
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
           }
           else {*/
               
               stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdseg="+(rss3.getInt("qtdseg")-qtdSeg)
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
               stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdter="+(rss3.getInt("qtdter")-qtdTer)
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
               stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdqua="+(rss3.getInt("qtdqua")-qtdQua)
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
               stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdqui="+(rss3.getInt("qtdqui")-qtdQui)
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
               stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdsex="+(rss3.getInt("qtdsex")-qtdSex)
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
           //}
           stmt.close();
            rss.close();
            rss2.close();
            rss3.close();
            connection.close();
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    public void AdicionarEncomenda(int idRestaurante, String Produto, int qtdSeg, int qtdTer, int qtdQua, int qtdQui, int qtdSex, int getWeekofYear2, int anoPesquisa)  {
          try {
              
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            Statement stmt3=null;
            Statement stmt4=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            stmt3 = connection.createStatement();
            stmt4 = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".encomenda") ;
            ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");    
            rss2.next();
            ResultSet rss4 = stmt4.executeQuery("SELECT SUM(getWeekofYear) FROM "+dbName+".encomenda "
                    + "WHERE getWeekofYear="+getWeekofYear+" AND YEAR(daquinta_teste.encomenda.data)='"+ano+"' "
                    + "AND produtos_idprodutos="+rss2.getInt("produtos.idprodutos")+" AND restaurantes_idrestaurantes="+idRestaurante) ;
            rss4.next();
           
            if (rss4.getInt("SUM(getWeekofYear)")==0) {
                int x=0;
                int y=0;
                rss.last();
                y=rss.getRow();
                if (y==0){
                    x=1;
                }else if (y != 0){
                    rss.last();
                    x=rss.getInt(1)+1;
                }

                stmt.executeUpdate("INSERT INTO "+dbName+".encomenda VALUES ('"+x+"','" + 
                idRestaurante + "', '" + rss2.getInt("idprodutos") + "', '" + dateFormat.format(date)  + "', '" +
                qtdSeg + "', '" + qtdTer + "', '" + qtdQua + "', '" + qtdQui + "', '" +
                qtdSex + "', '"+getWeekofYear+"')");
                
            }
            else{
                
            
                ResultSet rss3 = stmt3.executeQuery("SELECT * FROM "+dbName+".encomenda WHERE "
                    + "encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                   " AND encomenda.restaurantes_idrestaurantes="+idRestaurante +";") ;
               
                rss3.next();
         
          
               
                stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdseg="+qtdSeg
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
                stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdter="+qtdTer
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
                stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdqua="+qtdQua
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
                stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdqui="+qtdQui
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
                stmt.executeUpdate("UPDATE "+dbName+".encomenda SET qtdsex="+qtdSex
                    +" WHERE encomenda.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND restaurantes_idrestaurantes="+idRestaurante+";");
                 rss3.close();
           }
           stmt.close();
            rss.close();
            rss2.close();
            
            rss4.close();
           
            connection.close();
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    public void AdicionarProducaoSemanal(int idProdutor, String Produto, int qtdSeg, int qtdTer, int qtdQua, int qtdQui, int qtdSex, int getWeekofYear2, int anoPesquisa)  {
          try {
              
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            Statement stmt3=null;
            Statement stmt4=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            stmt3 = connection.createStatement();
            stmt4 = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".producao_semanal") ;
            rss.next();
            ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");    
            rss2.next();
            ResultSet rss4 = stmt4.executeQuery("SELECT SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex) FROM "+dbName+".producao_semanal "
                    + "WHERE getWeekofYear="+getWeekofYear+" AND YEAR("+dbName+".producao_semanal.data)='"+ano+"' "
                    + "AND produtos_idprodutos="+rss2.getInt("produtos.idprodutos")+" AND produtores_idprodutores="+idProdutor) ;
            rss4.next();
            int x=0;
            int y=0;
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
                
            if (rss4.getInt("SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex)")==0) {
                stmt.executeUpdate("INSERT INTO producao_semanal VALUES ('"+x+"','" + 
                idProdutor + "', '" + rss2.getInt("idprodutos") + "', '" + dateFormat.format(date)  + "', '" +
                qtdSeg + "', '" + qtdTer + "', '" + qtdQua + "', '" + qtdQui + "', '" +
                qtdSex + "', '"+getWeekofYear+"')");
                
            }
            else{
                
            
                ResultSet rss3 = stmt3.executeQuery("SELECT * FROM producao_semanal WHERE "
                    + "producao_semanal.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                   " AND producao_semanal.produtores_idprodutores="+idProdutor +";") ;
               
                rss3.next();
         
          
               
                stmt.executeUpdate("UPDATE "+dbName+".producao_semanal SET qtdseg="+qtdSeg
                    +" WHERE producao_semanal.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND produtores_idprodutores="+idProdutor+";");
                stmt.executeUpdate("UPDATE "+dbName+".producao_semanal SET qtdter="+qtdTer
                    +" WHERE producao_semanal.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND produtores_idprodutores="+idProdutor+";");
                stmt.executeUpdate("UPDATE "+dbName+".producao_semanal SET qtdqua="+qtdQua
                    +" WHERE producao_semanal.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND produtores_idprodutores="+idProdutor+";");
                stmt.executeUpdate("UPDATE "+dbName+".producao_semanal SET qtdqui="+qtdQui
                    +" WHERE producao_semanal.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND produtores_idprodutores="+idProdutor+";");
                stmt.executeUpdate("UPDATE "+dbName+".producao_semanal SET qtdsex="+qtdSex
                    +" WHERE producao_semanal.getWeekofYear="+getWeekofYear+" AND produtos_idprodutos="+rss2.getInt("idprodutos")+
                    " AND produtores_idprodutores="+idProdutor+";");
                 rss3.close();
           }
           stmt.close();
            rss.close();
            rss2.close();
            
            rss4.close();
           
            connection.close();
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    
    public void AdicionarStockArmazenaveis(int idProdutor, String Produto, int quantidade, int mes)  {
          try {
              
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            Statement stmt3=null;
            Statement stmt4=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            stmt3 = connection.createStatement();
            stmt4 = connection.createStatement();
            ResultSet rss = stmt.executeQuery("SELECT * FROM "+dbName+".stock") ;
            ResultSet rss2 = stmt2.executeQuery("SELECT * FROM "+dbName+".produtos WHERE nome='"+Produto+"'");    
            rss2.next();
             ResultSet rss4 = stmt4.executeQuery("SELECT SUM(mes) FROM "+dbName+".stock "
                     + " WHERE mes="+mes+" AND ano="+ano
                     + " AND produtos_idprodutos="+rss2.getInt("produtos.idprodutos")
                     +" AND produtores_idprodutores="+idProdutor);
            
            rss4.next();
            rss.next();
            if (rss4.getInt("SUM(mes)")==0) {
                int x=0;
                int y=0;
                y=rss.getRow();
                if (y==0){
                    x=1;
                }else if (y != 0){
                    rss.last();
                    x=rss.getInt(1)+1;
                }
                //System.out.println("SUM " + x);
                stmt.executeUpdate("INSERT INTO "+dbName+".stock VALUES ('"+x+"','" + 
                rss2.getInt("idprodutos") + "', '" + idProdutor + "', '" + quantidade  + "', '" +
                ano + "', '" + mes + "')");
                
            }
            else{
             
                stmt.executeUpdate("UPDATE "+dbName+".stock SET quantidade="+quantidade
                        + " WHERE mes="+mes+" AND produtos_idprodutos="+rss2.getInt("idprodutos")
                        + " AND produtores_idprodutores="+idProdutor+" AND ano="+ano+";");
               
               
           }
           stmt.close();
            rss.close();
            rss2.close();
            
            rss4.close();
           
            connection.close();
            System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    public void inserirNovoLogin(String user, String notas) {
        try {
            
            connection = DB.createDBConnection();
            Statement stmt=null;
            Statement stmt2=null;
            stmt = connection.createStatement();
            stmt2 = connection.createStatement();
            
            ResultSet rss = stmt2.executeQuery("SELECT * FROM "+dbName+".login") ;
            //System.out.println("Hora e data:" + dateFormat2.format(date));
            int x=0;
            int y=0;
            rss.last();
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
           
            stmt.executeUpdate("INSERT INTO "+dbName+".login  VALUES ('"+x+"','" + user + "', '" + dateFormat2.format(date) + "', '" + notas +  "')");
    
                        stmt.close();
                        //rs.close();
                        rss.close();
                        connection.close();
                        System.out.println("Disconnected from database");
                        
                        
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}
