package chavevalor;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class ChaveValorClient {
  public static void main(String[] args) {
    try {
      TTransport transport = new TSocket("localhost", 9090);
      transport.open();

      TProtocol protocol = new TBinaryProtocol(transport);
      ChaveValor.Client client = new ChaveValor.Client(protocol);
      String valorAntigo = client.setKV(10, "Valor para chave 10");
      System.out.println("Valor antigo = " + valorAntigo);

      System.out.println("Valor = " + client.getKV(10));
      System.out.println("Apagando valor...");

      client.delKV(10);
      System.out.println("Valor = " + client.getKV(10));

      transport.close();
    } catch (TException e) {
      e.printStackTrace();
    }
  }
}
