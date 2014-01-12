//
//  Follow_the_FingerAppDelegate.m
//  Follow the Finger
//
//  Created by Seth Battis on 3/11/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import "Follow_the_FingerAppDelegate.h"
#import "GLView.h"

@implementation Follow_the_FingerAppDelegate

@synthesize window;
@synthesize glView;

- (void)applicationDidFinishLaunching:(UIApplication *)application {
    
	glView.animationInterval = 1.0 / kRenderingFrequency;
	[glView startAnimation];
}


- (void)applicationWillResignActive:(UIApplication *)application {
	glView.animationInterval = 1.0 / kInactiveRenderingFrequency;
}


- (void)applicationDidBecomeActive:(UIApplication *)application {
	glView.animationInterval = 1.0 / 60.0;
}


- (void)dealloc {
	[window release];
	[glView release];
	[super dealloc];
}

@end
