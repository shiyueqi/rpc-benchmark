java -Xms2G -Xmx2G -cp ./target/classes;./target/lib/*  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc1.log -Dwrite.statistics=true com.unionpay.rpc.benchmark.magpie.common.MagpieTest 50 300000 true false ture false > magpie_benchmark_rpc_obj_50_300000.log
pause