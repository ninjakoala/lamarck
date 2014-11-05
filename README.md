```clojure
[com.ninjakoala/lamarck "1.0.0"]
```

```clojure
(ns yourapp
  (:require [ninjakoala.lamarck :as l]))

; The list of instances:
l/instances

; Retrieve the data for your favourite instance:
(l/instance "c3.4xlarge")

; Instances look like this:
{:network-performance "High",
 :vcpu 16,
 :family "Unknown",
 :memory 30.0,
 :instance-type "c3.4xlarge",
 :arch ["x86_64"],
 :vpc {:ips-per-eni 30, :max-enis 8},
 :storage {:devices 2, :size 160, :ssd true},
 :ecu 55.0,
 :pricing
 {:ap-northeast-1 {:linux 1.021, :mswin 1.849},
  :ap-southeast-1 {:linux 1.058, :mswin 1.906},
  :ap-southeast-2 {:linux 1.058, :mswin 1.906},
  :eu-west-1 {:linux 0.956, :mswin 1.504},
  :sa-east-1 {:linux 1.3, :mswin 1.964},
  :us-east-1 {:linux 0.84, :mswin 1.504},
  :us-west-1 {:linux 0.956, :mswin 1.504},
  :us-west-2 {:linux 0.84, :mswin 1.504}},
 :ebs-optimized? true}
```

# lamarck

Provides the data from [Garret Heaton's](https://github.com/powdahound) excellent [ec2instances.info](https://github.com/powdahound/ec2instances.info) project in Clojure form for munging in your application. At [MixRadio](http://dev.mixrad.io/blog/) we use this library to help us estimate our EC2 costs.

## Lamarck who?

[Jean-Baptiste Lamarck](http://en.wikipedia.org/wiki/Jean-Baptiste_Lamarck), according to [wikipedia](http://en.wikipedia.org/wiki/Cloud#Luke_Howard_and_Jean-Baptiste_Lamarck) he worked on cloud classification. It seemed vaguely appropriate!

## License

Copyright © 2014 Neil Prosser

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
