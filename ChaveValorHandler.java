package chavevalor;

import org.apache.thrift.TException;
import java.util.HashMap;
import chavevalor.*;

public class ChaveValorHandler implements ChaveValor.Iface {
  private HashMap<Integer, String> kv = new HashMap<>();

  @Override
  public String getKV(int key) throws TException {
    if(kv.containsKey(key)) return kv.get(key);
    else throw new KeyNotFound();
  }

  @Override
  public String setKV(int key, String valor) throws TException {
    try {
      String oldValue = getKV(key);

      kv.put(key, valor);

      return oldValue;
    } catch (KeyNotFound e) {
      kv.put(key, valor);
      return "";
    } catch (Exception e2) {
      System.out.println("LOG_4");
      throw e2;
    }
  }

  @Override
  public void delKV(int key) throws TException {
    kv.remove(key);
  }    
}
